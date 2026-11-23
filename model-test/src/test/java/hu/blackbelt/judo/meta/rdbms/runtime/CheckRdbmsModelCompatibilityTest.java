package hu.blackbelt.judo.meta.rdbms.runtime;

/*-
 * #%L
 * JUDO :: Rdbms :: Model :: Test
 * %%
 * Copyright (C) 2018 - 2024 BlackBelt Technology
 * %%
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License, v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is
 * available at https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 * #L%
 */

import hu.blackbelt.judo.meta.rdbms.RdbmsFactory;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;
import hu.blackbelt.judo.meta.rdbms.RdbmsValueField;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsIncrementalTestSupport.loadFixture;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** {@link CheckRdbmsModelCompatibility}: report content and the Epsilon free execution. */
public class CheckRdbmsModelCompatibilityTest {

    /** Adds a value field (with an XMI id, which the clone util needs) to the first table. */
    static void addColumn(RdbmsModel model) {
        hu.blackbelt.judo.meta.rdbms.RdbmsModel root = RdbmsIncrementalTestSupport.root(model);
        RdbmsTable table = root.getRdbmsTables().get(0);
        RdbmsValueField field = RdbmsFactory.eINSTANCE.createRdbmsValueField();
        field.setUuid("added-column");
        field.setName("added-column");
        field.setSqlName("ADDED_COLUMN");
        field.setRdbmsTypeName("TEXT");
        table.getFields().add(field);
        Resource resource = field.eResource();
        ((XMIResource) resource).setID(field, "added-column");
    }

    @Test
    @DisplayName("TP-12: the report lists the delete table operation")
    void reportListsDeleteTable() throws Exception {
        RdbmsModel stored = loadFixture("initial-rdbms_hsqldb");
        RdbmsModel deployed = loadFixture("initial-rdbms_hsqldb");
        // the stored model has a table the deployed one lacks
        hu.blackbelt.judo.meta.rdbms.RdbmsModel deployedRoot = RdbmsIncrementalTestSupport.root(deployed);
        RdbmsTable removed = deployedRoot.getRdbmsTables().stream()
                .filter(t -> t.getClass().getSimpleName().equals("RdbmsTableImpl"))
                .filter(t -> deployedRoot.getRdbmsTables().stream().noneMatch(o -> o != t && o.getFields().stream()
                        .anyMatch(f -> f instanceof hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey
                                && t.getFields().contains(((hu.blackbelt.judo.meta.rdbms.RdbmsForeignKey) f).getReferenceKey()))))
                .findFirst().orElseThrow(IllegalStateException::new);
        String name = removed.getName();
        String sqlName = removed.getSqlName();
        EcoreUtil.delete(removed, true);

        StringBuilder report = new StringBuilder();
        boolean identical = CheckRdbmsModelCompatibility.isRdbmsModelIdentical(stored, deployed, "hsqldb", report, false);

        assertFalse(identical);
        assertTrue(report.toString().contains("Delete table operation: " + name + " - " + sqlName), report.toString());
    }

    @Test
    @DisplayName("The report lists create table, create field and modify operations; identical models are compatible")
    void reportAndIdentical() throws Exception {
        StringBuilder none = new StringBuilder();
        assertTrue(CheckRdbmsModelCompatibility.isRdbmsModelIdentical(loadFixture("initial-rdbms_hsqldb"),
                loadFixture("initial-rdbms_hsqldb"), "hsqldb", none, false));
        assertEquals(0, none.length());

        RdbmsModel candidate = loadFixture("initial-rdbms_hsqldb");
        addColumn(candidate);
        StringBuilder report = new StringBuilder();
        assertFalse(CheckRdbmsModelCompatibility.isRdbmsModelIdentical(loadFixture("initial-rdbms_hsqldb"), candidate,
                "hsqldb", report, false));
        assertTrue(report.toString().contains("DATABASE HAVE TO BE UPDATED!"), report.toString());
        assertTrue(report.toString().contains("Create field: added-column - ADDED_COLUMN"), report.toString());
    }

    @Test
    @DisplayName("TP-39: the check runs with Epsilon hidden from the class loader")
    void checkRunsWithoutEpsilon() throws Exception {
        EpsilonHidingClassLoader loader = new EpsilonHidingClassLoader(getClass().getClassLoader());

        // the isolation has teeth: Epsilon is on the test classpath but not visible from the loader
        Class.forName("hu.blackbelt.epsilon.runtime.execution.ExecutionContext");
        assertThrows(ClassNotFoundException.class, () -> loader.loadClass("hu.blackbelt.epsilon.runtime.execution.ExecutionContext"));
        assertThrows(ClassNotFoundException.class, () -> loader.loadClass("org.eclipse.epsilon.eol.EolModule"));
        loader.blocked.clear();

        Class<?> probe = loader.loadClass(IsolatedCompatibilityProbe.class.getName());
        String result = (String) probe.getMethod("run").invoke(null);

        String[] parts = result.split("\\|", 3);
        assertEquals("true", parts[0]);
        assertEquals("false", parts[1]);
        assertTrue(parts[2].contains("Create field: added-column - ADDED_COLUMN"), parts[2]);
        assertTrue(loader.blocked.isEmpty(), "Epsilon classes were requested: " + loader.blocked);

        // control: the ETL oracle needs Epsilon, so it fails in the same class loader
        InvocationTargetException etl = assertThrows(InvocationTargetException.class,
                () -> probe.getMethod("runEtl").invoke(null));
        assertTrue(etl.getCause() instanceof LinkageError || etl.getCause() instanceof ClassNotFoundException
                || (etl.getCause() != null && etl.getCause().getCause() instanceof ClassNotFoundException),
                String.valueOf(etl.getCause()));
        assertFalse(loader.blocked.isEmpty());
    }

    /** Child first class loader which refuses the Epsilon packages and records every attempt. */
    static final class EpsilonHidingClassLoader extends ClassLoader {
        final List<String> blocked = new ArrayList<>();

        EpsilonHidingClassLoader(ClassLoader parent) {
            super(parent);
        }

        @Override
        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            if (name.startsWith("org.eclipse.epsilon.") || name.startsWith("hu.blackbelt.epsilon.")) {
                blocked.add(name);
                throw new ClassNotFoundException(name);
            }
            synchronized (getClassLoadingLock(name)) {
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("jdk.")
                            || name.startsWith("sun.") || name.startsWith("com.sun.") || name.startsWith("org.w3c.")
                            || name.startsWith("org.xml.")) {
                        c = getParent().loadClass(name);
                    } else {
                        try (InputStream in = getParent().getResourceAsStream(name.replace('.', '/') + ".class")) {
                            if (in == null) {
                                c = getParent().loadClass(name);
                            } else {
                                byte[] bytes = in.readAllBytes();
                                c = defineClass(name, bytes, 0, bytes.length);
                            }
                        } catch (IOException e) {
                            throw new ClassNotFoundException(name, e);
                        }
                    }
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }
    }
}
