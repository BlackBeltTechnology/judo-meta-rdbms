package hu.blackbelt.judo.meta.rdbms.osgi.itest;

/*-
 * #%L
 * JUDO :: Rdbms :: Model
 * %%
 * Copyright (C) 2018 - 2022 BlackBelt Technology
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
import hu.blackbelt.judo.meta.rdbms.runtime.CheckRdbmsModelCompatibility;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel.RdbmsValidationException;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel.SaveArguments;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsConfigurationBuilder;
import hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsModelBuilder;
import hu.blackbelt.judo.meta.rdbms.runtime.RdbmsUtils;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static hu.blackbelt.judo.meta.rdbms.osgi.itest.KarafFeatureProvider.karafConfig;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.ops4j.pax.exam.CoreOptions.maven;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.OptionUtils.combine;

/**
 * The compatibility check with the Java incremental engine inside Karaf. This harness also installs Epsilon (as
 * {@link RdbmsModelLoadITest}), so it proves only that the Java engine runs in OSGi; the proof that the check needs no
 * Epsilon is the class loader isolation unit test (model-test) and the judo-platform itest.
 */
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
@Slf4j
public class RdbmsCompatibilityITest {

    @Configuration
    public Option[] config() throws IOException {
        return combine(karafConfig(this.getClass()),
                mavenBundle(maven()
                        .groupId("hu.blackbelt.judo.meta")
                        .artifactId("hu.blackbelt.judo.meta.rdbms.osgi")
                        .versionAsInProject()));
    }

    /** A model with one table, saved and loaded again, so every element has an XMI id. */
    private static RdbmsModel loadedModel(boolean withColumn) throws IOException, RdbmsValidationException {
        RdbmsModel model = RdbmsModel.buildRdbmsModel().uri(URI.createFileURI("compatibility.model")).build();
        RdbmsTable table = RdbmsUtils.newRdbmsTableBuilderInit("Tables.TestTable").build();
        table.setSqlName("TEST_TABLE");
        model.getRdbmsModelResourceSupport().addContent(RdbmsModelBuilder.create()
                .withName("test")
                .withVersion("1.0.0")
                .withConfiguration(RdbmsConfigurationBuilder.create().withDialect("hsqldb").build())
                .withRdbmsTables(table)
                .build());

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        model.saveRdbmsModel(SaveArguments.rdbmsSaveArgumentsBuilder().outputStream(os));
        RdbmsModel loaded = RdbmsModel.loadRdbmsModel(RdbmsModel.LoadArguments.rdbmsLoadArgumentsBuilder()
                .uri(URI.createFileURI("compatibility-loaded.model"))
                .inputStream(new ByteArrayInputStream(os.toByteArray()))
                .validateModel(false));

        if (withColumn) {
            RdbmsTable loadedTable = loaded.getRdbmsModelResourceSupport().getStreamOfRdbmsRdbmsTable().findFirst().get();
            RdbmsValueField column = RdbmsFactory.eINSTANCE.createRdbmsValueField();
            column.setUuid("added-column");
            column.setName("added-column");
            column.setSqlName("ADDED_COLUMN");
            column.setRdbmsTypeName("TEXT");
            loadedTable.getFields().add(column);
            ((XMIResource) column.eResource()).setID(column, "added-column");
        }
        return loaded;
    }

    @Test
    public void testCompatibilityCheckWithJavaEngine() throws Exception {
        assertTrue(CheckRdbmsModelCompatibility.isRdbmsModelIdentical(
                loadedModel(false), loadedModel(false), "hsqldb", new StringBuilder(), false));

        StringBuilder report = new StringBuilder();
        assertFalse(CheckRdbmsModelCompatibility.isRdbmsModelIdentical(
                loadedModel(false), loadedModel(true), "hsqldb", report, false));
        assertTrue(report.toString(), report.toString().contains("Create field: added-column - ADDED_COLUMN"));
    }
}
