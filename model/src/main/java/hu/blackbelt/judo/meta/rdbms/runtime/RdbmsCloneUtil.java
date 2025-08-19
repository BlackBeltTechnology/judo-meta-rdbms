package hu.blackbelt.judo.meta.rdbms.runtime;

/*-
 * #%L
 * JUDO :: Rdbms :: Model
 * %%
 * Copyright (C) 2018 - 2023 BlackBelt Technology
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

import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel;
import hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel.buildRdbmsModel;
import static hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport.rdbmsModelResourceSupportBuilder;

public class RdbmsCloneUtil {
    private static Logger log = LoggerFactory.getLogger(RdbmsCloneUtil.class);

    public static RdbmsModel cloneRdbms(RdbmsModel model, String postfix, boolean setUiid) {
        RdbmsModel clonedModel = buildRdbmsModel()
                .build();

        RdbmsModelResourceSupport modelResourceSupport = rdbmsModelResourceSupportBuilder()
                .resourceSet(model.getResourceSet())
                .uri(org.eclipse.emf.common.util.URI.createURI("rdbms:" + model.getName()))
                .build();

        String appended = "";
        if (postfix != null && postfix.trim() != "") {
            appended = "_" + postfix;
        }

        String finalAppended = appended;
        Map<EObject, EObject> objectMap = new HashMap<>();

        @SuppressWarnings("serial")
        EcoreUtil.Copier copier = new EcoreUtil.Copier() {
            @Override
            public EObject copy(EObject eObject) {
                EObject newInstance = super.copy(eObject);
                objectMap.put(eObject, newInstance);
                return newInstance;
            }
        };

        Optional<hu.blackbelt.judo.meta.rdbms.RdbmsModel> rdbmsModel = modelResourceSupport.getStreamOfRdbmsRdbmsModel().findFirst();
        String version = rdbmsModel.get().getVersion();
        EObject cloned = copier.copy(rdbmsModel.get());
        copier.copyReferences();

        clonedModel.getResource().getContents()
                .add(cloned);

        objectMap.forEach((eObject, newInstance) -> {
            if (eObject.eResource() instanceof XMIResource && newInstance.eResource() instanceof XMIResource) {
                String xmiId =  ((XMIResource) eObject.eResource()).getID(eObject);
                String rdbmsXmiId = xmiId;
                if (xmiId.endsWith("_" + version)) {
                    rdbmsXmiId = xmiId.substring(0, xmiId.length() - version.length() - 1);
                }

                if (setUiid) {
                    Optional<EAttribute> uuid = newInstance.eClass().getEAllAttributes().stream()
                            .filter(a -> a.getName().equalsIgnoreCase("uuid")).findFirst();
                    if (uuid.isPresent()) {
                        String currentValue = (String) newInstance.eGet(uuid.get());
                        if (currentValue == null || "".equals(currentValue.trim()) || !rdbmsXmiId.equals(currentValue)) {
                            newInstance.eSet(uuid.get(), rdbmsXmiId);
                        }
                    }
                }
                if (xmiId != null && !"".equals(xmiId.trim())) {
                    String a = finalAppended;
                    if (xmiId.endsWith(finalAppended)) {
                        a = "";
                    }
                    XMIResource newXmiResource = (XMIResource) newInstance.eResource();
                    newXmiResource.setID(newInstance, ((XMIResource) eObject.eResource()).getID(eObject) + a);
                }
            }
        });

        return clonedModel;
    }
}
