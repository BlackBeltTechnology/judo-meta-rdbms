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

import hu.blackbelt.judo.meta.rdbms.RdbmsOperationMeta;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsIncrementalTestSupport.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/** Contract of {@link RdbmsIncrementalTransformation#transform}. */
public class RdbmsIncrementalTransformationTest {

    @Test
    @DisplayName("TP-1: identical models give an empty incremental model")
    void identicalModels() {
        RdbmsModel previous = RdbmsIncrementalEquivalenceTest.base("1");
        RdbmsModel current = RdbmsIncrementalEquivalenceTest.base("2");
        hu.blackbelt.judo.meta.rdbms.RdbmsModel previousRoot = root(previous);
        hu.blackbelt.judo.meta.rdbms.RdbmsModel currentRoot = root(current);
        RdbmsModel incremental = RdbmsModel.buildRdbmsModel().build();

        RdbmsIncrementalTransformation.transform(previous, current, incremental, "postgresql", false);

        assertEquals(4, incremental.getResource().getContents().size());
        hu.blackbelt.judo.meta.rdbms.RdbmsModel operationModel = (hu.blackbelt.judo.meta.rdbms.RdbmsModel)
                incremental.getResource().getContents().get(0);
        RdbmsOperationMeta meta = (RdbmsOperationMeta) incremental.getResource().getContents().get(1);
        assertEquals(0, operationModel.getTableOperations().size());
        assertEquals("1_2", operationModel.getVersion());
        assertEquals("M", operationModel.getName());
        assertEquals("postgresql", operationModel.getConfiguration().getDialect());
        assertSame(operationModel, meta.getIncrementalModel());
        assertSame(previousRoot, meta.getPreviousModel());
        assertSame(currentRoot, meta.getCurrentModel());
        // previous and new model are moved into the incremental resource, in this order
        assertSame(previousRoot, incremental.getResource().getContents().get(2));
        assertSame(currentRoot, incremental.getResource().getContents().get(3));
        assertEquals(1, incremental.getRdbmsModelResourceSupport().getStreamOfRdbmsRdbmsOperationMeta().count());
    }

    @Test
    @DisplayName("TP-11: null arguments are rejected by name and nothing is modified")
    void nullArguments() {
        RdbmsModel previous = RdbmsIncrementalEquivalenceTest.base("1");
        RdbmsModel current = RdbmsIncrementalEquivalenceTest.base("2");
        RdbmsModel incremental = RdbmsModel.buildRdbmsModel().build();

        assertEquals("previousModel", assertThrows(NullPointerException.class,
                () -> RdbmsIncrementalTransformation.transform(null, current, incremental, "hsqldb", false)).getMessage());
        assertEquals("newModel", assertThrows(NullPointerException.class,
                () -> RdbmsIncrementalTransformation.transform(previous, null, incremental, "hsqldb", false)).getMessage());
        assertEquals("incrementalModel", assertThrows(NullPointerException.class,
                () -> RdbmsIncrementalTransformation.transform(previous, current, null, "hsqldb", false)).getMessage());
        assertEquals("dialect", assertThrows(NullPointerException.class,
                () -> RdbmsIncrementalTransformation.transform(previous, current, incremental, null, false)).getMessage());

        assertTrue(incremental.getResource().getContents().isEmpty());
        assertEquals(1, previous.getResource().getContents().size());
        assertEquals(1, current.getResource().getContents().size());
    }

    @Test
    @DisplayName("A model without an RdbmsModel root is rejected before anything is modified")
    void modelWithoutRoot() {
        RdbmsModel empty = RdbmsModel.buildRdbmsModel().build();
        RdbmsModel current = RdbmsIncrementalEquivalenceTest.base("2");
        RdbmsModel incremental = RdbmsModel.buildRdbmsModel().build();
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> RdbmsIncrementalTransformation.transform(empty, current, incremental, "hsqldb", false));
        assertTrue(e.getMessage().contains("previousModel"), e.getMessage());
        assertTrue(incremental.getResource().getContents().isEmpty());
    }
}
