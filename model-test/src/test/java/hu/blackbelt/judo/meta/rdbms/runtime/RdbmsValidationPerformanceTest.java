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

import hu.blackbelt.judo.meta.rdbms.RdbmsIdentifierField;
import hu.blackbelt.judo.meta.rdbms.RdbmsTable;
import hu.blackbelt.judo.meta.rdbms.RdbmsValueField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.UUID;

import static hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsBuilders.*;

/**
 * Performance tests comparing EVL and Java validation execution times.
 *
 * <p>These tests generate large models and measure validation execution times
 * for both EVL and Java validators. Results are logged for comparison.</p>
 *
 * <p>Run these tests with:</p>
 * <pre>{@code
 * mvn test -Dtest=RdbmsValidationPerformanceTest
 * }</pre>
 *
 * @see AbstractRdbmsValidationTest
 */
@DisplayName("RDBMS Validation Performance Tests")
@Tag("performance")
public class RdbmsValidationPerformanceTest extends AbstractRdbmsValidationTest {

    private static final int ELEMENT_COUNT = 10000;

    @Test
    @DisplayName("Performance comparison with " + ELEMENT_COUNT + " elements")
    void testPerformanceWith10000Elements() throws Exception {
        initModel();

        log.info("Generating model with {} elements...", ELEMENT_COUNT);
        long generateStart = System.currentTimeMillis();

        // Generate 10,000 table elements with fields
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            RdbmsIdentifierField primaryKey = newRdbmsIdentifierFieldBuilder()
                    .withName("id_" + i)
                    .withUuid(UUID.randomUUID().toString())
                    .withSqlName("ID_" + i)
                    .withMandatory(true)
                    .withRdbmsTypeName("BIGINT")
                    .build();

            RdbmsValueField valueField = newRdbmsValueFieldBuilder()
                    .withName("value_" + i)
                    .withUuid(UUID.randomUUID().toString())
                    .withSqlName("VALUE_" + i)
                    .withMandatory(false)
                    .withRdbmsTypeName("VARCHAR")
                    .withSize(255)
                    .build();

            RdbmsTable table = newRdbmsTableBuilder()
                    .withName("Table_" + i)
                    .withUuid(UUID.randomUUID().toString())
                    .withSqlName("TABLE_" + i)
                    .withPrimaryKey(primaryKey)
                    .withFields(valueField)
                    .build();

            rdbmsModel.getResource().getContents().add(table);
        }

        long generateTime = System.currentTimeMillis() - generateStart;
        log.info("Model generation completed in {}ms ({} elements)", generateTime, ELEMENT_COUNT);

        // Time EVL validation
        log.info("Running EVL validation...");
        this.validatorType = ValidatorType.EVL;
        long evlStart = System.currentTimeMillis();
        try {
            runEvlValidation(Collections.emptyList(), Collections.emptyList());
        } catch (Exception e) {
            log.warn("EVL validation failed (expected if no rules): {}", e.getMessage());
        }
        long evlTime = System.currentTimeMillis() - evlStart;

        // Time Java validation (sequential)
        log.info("Running Java validation (sequential)...");
        long javaSeqStart = System.currentTimeMillis();
        try {
            runJavaValidation(Collections.emptyList(), Collections.emptyList(), false);
        } catch (Exception e) {
            log.warn("Java sequential validation failed (expected if no rules): {}", e.getMessage());
        }
        long javaSeqTime = System.currentTimeMillis() - javaSeqStart;

        // Time Java validation (parallel)
        log.info("Running Java validation (parallel)...");
        long javaParStart = System.currentTimeMillis();
        try {
            runJavaValidation(Collections.emptyList(), Collections.emptyList(), true);
        } catch (Exception e) {
            log.warn("Java parallel validation failed (expected if no rules): {}", e.getMessage());
        }
        long javaParTime = System.currentTimeMillis() - javaParStart;

        // Log results
        log.info("====================================================");
        log.info("Performance results for {} elements:", ELEMENT_COUNT);
        log.info("====================================================");
        log.info("  Model generation:      {:>8}ms", generateTime);
        log.info("  EVL validation:        {:>8}ms", evlTime);
        log.info("  Java (sequential):     {:>8}ms", javaSeqTime);
        log.info("  Java (parallel):       {:>8}ms", javaParTime);
        log.info("====================================================");

        if (javaSeqTime > 0) {
            double evlVsJavaSeq = (double) evlTime / javaSeqTime;
            log.info("  EVL vs Java (seq):     {:>8.2f}x", evlVsJavaSeq);
        }
        if (javaParTime > 0) {
            double evlVsJavaPar = (double) evlTime / javaParTime;
            double seqVsPar = (double) javaSeqTime / javaParTime;
            log.info("  EVL vs Java (par):     {:>8.2f}x", evlVsJavaPar);
            log.info("  Java seq vs par:       {:>8.2f}x", seqVsPar);
        }
        log.info("====================================================");
    }

    @Test
    @DisplayName("Performance comparison with 1000 elements (quick test)")
    void testPerformanceWith1000Elements() throws Exception {
        initModel();

        int elementCount = 1000;
        log.info("Generating model with {} elements...", elementCount);

        // Generate 1,000 table elements
        for (int i = 0; i < elementCount; i++) {
            RdbmsIdentifierField primaryKey = newRdbmsIdentifierFieldBuilder()
                    .withName("id_" + i)
                    .withUuid(UUID.randomUUID().toString())
                    .withSqlName("ID_" + i)
                    .withMandatory(true)
                    .withRdbmsTypeName("BIGINT")
                    .build();

            RdbmsTable table = newRdbmsTableBuilder()
                    .withName("Table_" + i)
                    .withUuid(UUID.randomUUID().toString())
                    .withSqlName("TABLE_" + i)
                    .withPrimaryKey(primaryKey)
                    .build();

            rdbmsModel.getResource().getContents().add(table);
        }

        log.info("Model generation completed ({} elements)", elementCount);

        // Time EVL validation
        this.validatorType = ValidatorType.EVL;
        long evlStart = System.currentTimeMillis();
        try {
            runEvlValidation(Collections.emptyList(), Collections.emptyList());
        } catch (Exception e) {
            log.debug("EVL validation note: {}", e.getMessage());
        }
        long evlTime = System.currentTimeMillis() - evlStart;

        // Time Java validation
        long javaStart = System.currentTimeMillis();
        try {
            runJavaValidation(Collections.emptyList(), Collections.emptyList(), false);
        } catch (Exception e) {
            log.debug("Java validation note: {}", e.getMessage());
        }
        long javaTime = System.currentTimeMillis() - javaStart;

        log.info("Quick performance results ({} elements):", elementCount);
        log.info("  EVL: {}ms, Java: {}ms", evlTime, javaTime);
    }
}
