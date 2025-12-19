package hu.blackbelt.judo.meta.rdbms.cli;

import hu.blackbelt.judo.cli.api.FqnResolver;
import hu.blackbelt.judo.meta.rdbms.RdbmsElement;
import hu.blackbelt.judo.meta.rdbms.RdbmsField;
import hu.blackbelt.judo.meta.rdbms.RdbmsModel;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * RDBMS FQN resolver implementation.
 * <p>
 * Implements {@link FqnResolver} from model-cli-api for type-safe FQN resolution.
 * <p>
 * RDBMS model elements have a 'fullName' attribute that serves as the FQN.
 * For fields within tables, the FQN is constructed as tableName#fieldName.
 */
public class RdbmsFqnResolverImpl implements FqnResolver {

    private static final String TABLE_FIELD_SEPARATOR = "#";

    private final Map<String, EObject> cache = new ConcurrentHashMap<>();
    private ResourceSet resourceSet;

    @Override
    public synchronized void bind(ResourceSet resourceSet) {
        this.resourceSet = resourceSet;
        rebuildCache();
    }

    @Override
    public synchronized void unbind() {
        this.resourceSet = null;
        cache.clear();
    }

    @Override
    public boolean isBound() {
        return resourceSet != null;
    }

    @Override
    public String getModelType() {
        return "rdbms";
    }

    @Override
    public Optional<EObject> resolve(String fqn) {
        if (fqn == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(cache.get(fqn));
    }

    @Override
    public Stream<String> getFqnCollection() {
        return cache.keySet().stream();
    }

    @Override
    public Optional<String> getFqn(EObject eObject) {
        return computeFqn(eObject);
    }

    @Override
    public Stream<String> findByPattern(String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            return getFqnCollection();
        }
        return cache.keySet().stream()
                .filter(fqn -> fqn.matches(pattern));
    }

    @Override
    public Optional<EObject> resolveByXmiId(String xmiId) {
        if (xmiId == null || resourceSet == null) {
            return Optional.empty();
        }
        // Iterate through all resources to find element by URI fragment
        return resourceSet.getResources().stream()
                .map(resource -> {
                    try {
                        return resource.getEObject(xmiId);
                    } catch (Exception e) {
                        return null;
                    }
                })
                .filter(java.util.Objects::nonNull)
                .findFirst();
    }

    private void rebuildCache() {
        cache.clear();
        if (resourceSet == null) {
            return;
        }
        TreeIterator<?> iterator = resourceSet.getAllContents();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (next instanceof EObject) {
                EObject current = (EObject) next;
                computeFqn(current).ifPresent(fqn -> cache.put(fqn, current));
            }
        }
    }

    private Optional<String> computeFqn(EObject eObject) {
        // RdbmsModel - root element
        if (eObject instanceof RdbmsModel) {
            RdbmsModel rdbmsModel = (RdbmsModel) eObject;
            String name = rdbmsModel.getConfiguration() != null
                ? rdbmsModel.getConfiguration().getDialect()
                : "rdbms";
            return Optional.of(name);
        }

        // RdbmsTable (including RdbmsJunctionTable) - use fullName or name
        if (eObject instanceof RdbmsTable) {
            RdbmsTable rdbmsTable = (RdbmsTable) eObject;
            String fullName = rdbmsTable.getFullName();
            if (fullName != null && !fullName.isBlank()) {
                return Optional.of(fullName);
            }
            return Optional.ofNullable(rdbmsTable.getName());
        }

        // RdbmsField (including RdbmsValueField, RdbmsForeignKey, RdbmsIdentifierField)
        if (eObject instanceof RdbmsField) {
            RdbmsField rdbmsField = (RdbmsField) eObject;
            EObject container = rdbmsField.eContainer();
            if (container instanceof RdbmsTable) {
                RdbmsTable rdbmsTable = (RdbmsTable) container;
                String tableFqn = rdbmsTable.getFullName();
                if (tableFqn == null || tableFqn.isBlank()) {
                    tableFqn = rdbmsTable.getName();
                }
                if (tableFqn != null) {
                    return Optional.of(
                        tableFqn + TABLE_FIELD_SEPARATOR + rdbmsField.getName()
                    );
                }
            }
        }

        // Generic RdbmsElement - use fullName or uuid
        if (eObject instanceof RdbmsElement) {
            RdbmsElement rdbmsElement = (RdbmsElement) eObject;
            String fullName = rdbmsElement.getFullName();
            if (fullName != null && !fullName.isBlank()) {
                return Optional.of(fullName);
            }
            String uuid = rdbmsElement.getUuid();
            if (uuid != null && !uuid.isBlank()) {
                return Optional.of(uuid);
            }
            return Optional.ofNullable(rdbmsElement.getName());
        }

        // Fallback: use URI
        return Optional.of(EcoreUtil.getURI(eObject).toString());
    }
}
