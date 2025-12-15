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

import hu.blackbelt.judo.meta.rdbms.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.*;

import static hu.blackbelt.judo.meta.rdbms.util.builder.RdbmsBuilders.*;

/**
 * Performance tests using a programmatically generated real-world model.
 *
 * <p>This test generates an RDBMS model with semantics matching production applications
 * (based on rackinspect patterns), including:</p>
 * <ul>
 *   <li>Tables with audit fields (_id, _type, _version, _create_*, _update_*)</li>
 *   <li>Value fields with various types (TEXT, BOOLEAN, UUID, TIMESTAMP, INT4, DECIMAL)</li>
 *   <li>Foreign key relationships between tables</li>
 *   <li>Junction tables for many-to-many relationships</li>
 *   <li>Indexes on key fields</li>
 * </ul>
 *
 * <p>Run with:</p>
 * <pre>{@code
 * mvn test -Dgroups=performance
 * mvn test -Dgroups=performance -Drdbms.perf.tables=100 -Drdbms.perf.fieldsPerTable=15
 * }</pre>
 *
 * @see AbstractRdbmsValidationTest
 */
@DisplayName("RDBMS Real-World Model Performance Tests")
@Tag("performance")
public class RdbmsRealWorldPerformanceTest extends AbstractRdbmsValidationTest {

    // Configurable parameters via system properties
    private static final int TABLE_COUNT = Integer.getInteger("rdbms.perf.tables", 80);
    private static final int FIELDS_PER_TABLE = Integer.getInteger("rdbms.perf.fieldsPerTable", 12);

    // Field type distribution for realistic variety
    private static final String[] FIELD_TYPES = {"TEXT", "BOOLEAN", "UUID", "TIMESTAMP", "INT4", "DECIMAL"};
    private static final Random random = new Random(42); // Fixed seed for reproducibility

    // Track created elements for relationships
    private final List<RdbmsTable> tables = new ArrayList<>();
    private final List<RdbmsIdentifierField> identifierFields = new ArrayList<>();
    private int foreignKeyCount = 0;
    private int junctionTableCount = 0;
    private int indexCount = 0;

    @Test
    @DisplayName("Performance test with real-world model semantics")
    void testPerformanceWithRealWorldModel() throws Exception {
        initModel();

        log.info("====================================================");
        log.info("Generating real-world model...");
        log.info("  Configuration: tables={}, fieldsPerTable={}", TABLE_COUNT, FIELDS_PER_TABLE);
        log.info("====================================================");

        long generateStart = System.currentTimeMillis();
        generateRealWorldModel();
        long generateTime = System.currentTimeMillis() - generateStart;

        // Count elements
        int totalFields = countFields();

        log.info("====================================================");
        log.info("Model generation completed in {}ms", generateTime);
        log.info("  Tables:         {}", tables.size());
        log.info("  Total fields:   {}", totalFields);
        log.info("  Foreign keys:   {}", foreignKeyCount);
        log.info("  Junction tables:{}", junctionTableCount);
        log.info("  Indexes:        {}", indexCount);
        log.info("====================================================");

        // Time EVL validation
        log.info("Running EVL validation...");
        this.validatorType = ValidatorType.EVL;
        long evlStart = System.currentTimeMillis();
        try {
            runEvlValidation(Collections.emptyList(), Collections.emptyList());
        } catch (Exception e) {
            log.warn("EVL validation error: {}", e.getMessage());
        }
        long evlTime = System.currentTimeMillis() - evlStart;

        // Time Java validation (sequential)
        log.info("Running Java validation (sequential)...");
        long javaSeqStart = System.currentTimeMillis();
        try {
            runJavaValidation(Collections.emptyList(), Collections.emptyList(), false);
        } catch (Exception e) {
            log.warn("Java sequential validation error: {}", e.getMessage());
        }
        long javaSeqTime = System.currentTimeMillis() - javaSeqStart;

        // Time Java validation (parallel)
        log.info("Running Java validation (parallel)...");
        long javaParStart = System.currentTimeMillis();
        try {
            runJavaValidation(Collections.emptyList(), Collections.emptyList(), true);
        } catch (Exception e) {
            log.warn("Java parallel validation error: {}", e.getMessage());
        }
        long javaParTime = System.currentTimeMillis() - javaParStart;

        // Log performance results
        log.info("====================================================");
        log.info("PERFORMANCE RESULTS (Real-World Model)");
        log.info("====================================================");
        log.info("  Model size:        {} tables, {} fields", tables.size(), totalFields);
        log.info("  Generation time:   {}ms", generateTime);
        log.info("  EVL validation:    {}ms", evlTime);
        log.info("  Java (sequential): {}ms", javaSeqTime);
        log.info("  Java (parallel):   {}ms", javaParTime);
        log.info("----------------------------------------------------");
        if (javaSeqTime > 0) {
            log.info("  EVL vs Java (seq): {}x", String.format("%.2f", (double) evlTime / javaSeqTime));
        }
        if (javaParTime > 0) {
            log.info("  EVL vs Java (par): {}x", String.format("%.2f", (double) evlTime / javaParTime));
            log.info("  Seq vs Parallel:   {}x", String.format("%.2f", (double) javaSeqTime / javaParTime));
        }
        log.info("====================================================");
    }

    /**
     * Generates a real-world model with tables, relationships, and indexes.
     */
    private void generateRealWorldModel() {
        // Create tables with realistic structure
        for (int i = 0; i < TABLE_COUNT; i++) {
            RdbmsTable table = createTableWithFields("Entity" + i, i);
            tables.add(table);
            rdbmsModel.getResource().getContents().add(table);
        }

        // Add foreign key relationships (approx 1.5 FKs per table)
        int targetForeignKeys = (int) (TABLE_COUNT * 1.6);
        for (int i = 0; i < targetForeignKeys && tables.size() > 1; i++) {
            int sourceIdx = random.nextInt(tables.size());
            int targetIdx = random.nextInt(tables.size());
            if (sourceIdx != targetIdx) {
                createForeignKey(tables.get(sourceIdx), tables.get(targetIdx), i);
            }
        }

        // Add junction tables (approx 15% of table count)
        int targetJunctions = (int) (TABLE_COUNT * 0.15);
        for (int i = 0; i < targetJunctions && tables.size() > 1; i++) {
            int table1Idx = random.nextInt(tables.size());
            int table2Idx = random.nextInt(tables.size());
            if (table1Idx != table2Idx) {
                RdbmsJunctionTable junction = createJunctionTable(
                        tables.get(table1Idx), tables.get(table2Idx), i);
                rdbmsModel.getResource().getContents().add(junction);
            }
        }

        // Add indexes (approx 12% of table count)
        int targetIndexes = (int) (TABLE_COUNT * 0.12);
        for (int i = 0; i < targetIndexes; i++) {
            RdbmsTable table = tables.get(random.nextInt(tables.size()));
            createIndex(table, i);
        }
    }

    /**
     * Creates a table with realistic field structure matching production patterns.
     */
    private RdbmsTable createTableWithFields(String entityName, int index) {
        String tableName = "app.entities." + entityName;
        String sqlName = "T_ENTITIES_" + entityName.toUpperCase();

        // Create primary key (identifier field)
        RdbmsIdentifierField primaryKey = newRdbmsIdentifierFieldBuilder()
                .withName(tableName + "#_id")
                .withUuid(UUID.randomUUID().toString())
                .withSqlName("ID")
                .withMandatory(true)
                .withRdbmsTypeName("UUID")
                .build();
        identifierFields.add(primaryKey);

        // Create standard audit fields - start with primary key for containment
        List<RdbmsField> fields = new ArrayList<>();
        fields.add(primaryKey);  // Primary key must be in fields for EMF containment
        fields.addAll(createStandardAuditFields(tableName));

        // Add business fields with various types
        for (int i = 0; i < FIELDS_PER_TABLE; i++) {
            String fieldType = FIELD_TYPES[i % FIELD_TYPES.length];
            RdbmsValueField valueField = newRdbmsValueFieldBuilder()
                    .withName(tableName + "#field" + i)
                    .withUuid(UUID.randomUUID().toString())
                    .withSqlName("C_FIELD_" + i)
                    .withMandatory(i < 2) // First two fields are mandatory
                    .withRdbmsTypeName(fieldType)
                    .withSize(fieldType.equals("TEXT") ? 255 : -1)
                    .withPrecision(fieldType.equals("DECIMAL") ? 18 : -1)
                    .withScale(fieldType.equals("DECIMAL") ? 2 : -1)
                    .build();
            fields.add(valueField);
        }

        return newRdbmsTableBuilder()
                .withName(tableName)
                .withUuid(UUID.randomUUID().toString())
                .withSqlName(sqlName)
                .withPrimaryKey(primaryKey)
                .withFields(fields)
                .build();
    }

    /**
     * Creates standard audit fields matching production patterns.
     */
    private List<RdbmsValueField> createStandardAuditFields(String tableName) {
        List<RdbmsValueField> auditFields = new ArrayList<>();

        // _type field
        auditFields.add(newRdbmsValueFieldBuilder()
                .withName(tableName + "#_type")
                .withUuid(UUID.randomUUID().toString())
                .withSqlName("TYPE")
                .withMandatory(true)
                .withRdbmsTypeName("TEXT")
                .withSize(255)
                .build());

        // _version field
        auditFields.add(newRdbmsValueFieldBuilder()
                .withName(tableName + "#_version")
                .withUuid(UUID.randomUUID().toString())
                .withSqlName("VERSION")
                .withRdbmsTypeName("INT4")
                .build());

        // _create_username field
        auditFields.add(newRdbmsValueFieldBuilder()
                .withName(tableName + "#_create_username")
                .withUuid(UUID.randomUUID().toString())
                .withSqlName("CREATE_USERNAME")
                .withRdbmsTypeName("TEXT")
                .withSize(255)
                .build());

        // _create_user_id field
        auditFields.add(newRdbmsValueFieldBuilder()
                .withName(tableName + "#_create_user_id")
                .withUuid(UUID.randomUUID().toString())
                .withSqlName("CREATE_USER_ID")
                .withRdbmsTypeName("UUID")
                .build());

        // _create_timestamp field
        auditFields.add(newRdbmsValueFieldBuilder()
                .withName(tableName + "#_create_timestamp")
                .withUuid(UUID.randomUUID().toString())
                .withSqlName("CREATE_TIMESTAMP")
                .withRdbmsTypeName("TIMESTAMP")
                .build());

        // _update_username field
        auditFields.add(newRdbmsValueFieldBuilder()
                .withName(tableName + "#_update_username")
                .withUuid(UUID.randomUUID().toString())
                .withSqlName("UPDATE_USERNAME")
                .withRdbmsTypeName("TEXT")
                .withSize(255)
                .build());

        // _update_user_id field
        auditFields.add(newRdbmsValueFieldBuilder()
                .withName(tableName + "#_update_user_id")
                .withUuid(UUID.randomUUID().toString())
                .withSqlName("UPDATE_USER_ID")
                .withRdbmsTypeName("UUID")
                .build());

        // _update_timestamp field
        auditFields.add(newRdbmsValueFieldBuilder()
                .withName(tableName + "#_update_timestamp")
                .withUuid(UUID.randomUUID().toString())
                .withSqlName("UPDATE_TIMESTAMP")
                .withRdbmsTypeName("TIMESTAMP")
                .build());

        return auditFields;
    }

    /**
     * Creates a foreign key relationship between two tables.
     */
    private void createForeignKey(RdbmsTable sourceTable, RdbmsTable targetTable, int index) {
        RdbmsIdentifierField targetPrimaryKey = targetTable.getPrimaryKey();
        if (targetPrimaryKey == null) {
            return;
        }

        String fkSqlName = "FK_" + index;
        RdbmsForeignKey foreignKey = newRdbmsForeignKeyBuilder()
                .withName(sourceTable.getName() + "#fk_" + targetTable.getName().replace(".", "_") + "_" + index)
                .withUuid(UUID.randomUUID().toString())
                .withSqlName(fkSqlName)
                .withForeignKeySqlName(fkSqlName + "_FK")
                .withRdbmsTypeName("UUID")
                .withReferenceKey(targetPrimaryKey)
                .build();

        sourceTable.getFields().add(foreignKey);
        foreignKeyCount++;
    }

    /**
     * Creates a junction table for many-to-many relationships.
     */
    private RdbmsJunctionTable createJunctionTable(RdbmsTable table1, RdbmsTable table2, int index) {
        RdbmsIdentifierField pk1 = table1.getPrimaryKey();
        RdbmsIdentifierField pk2 = table2.getPrimaryKey();
        if (pk1 == null || pk2 == null) {
            return null;
        }

        String junctionName = "app.junctions.Junction" + index;

        // Create primary key for junction table
        RdbmsIdentifierField junctionPk = newRdbmsIdentifierFieldBuilder()
                .withName(junctionName + "#_id")
                .withUuid(UUID.randomUUID().toString())
                .withSqlName("ID")
                .withMandatory(true)
                .withRdbmsTypeName("UUID")
                .build();

        // Create foreign key fields
        RdbmsForeignKey field1 = newRdbmsForeignKeyBuilder()
                .withName(junctionName + "#field1")
                .withUuid(UUID.randomUUID().toString())
                .withSqlName("FK_FIELD1")
                .withForeignKeySqlName("FK_FIELD1_FK")
                .withRdbmsTypeName("UUID")
                .withMandatory(true)
                .withReferenceKey(pk1)
                .build();

        RdbmsForeignKey field2 = newRdbmsForeignKeyBuilder()
                .withName(junctionName + "#field2")
                .withUuid(UUID.randomUUID().toString())
                .withSqlName("FK_FIELD2")
                .withForeignKeySqlName("FK_FIELD2_FK")
                .withRdbmsTypeName("UUID")
                .withMandatory(true)
                .withReferenceKey(pk2)
                .build();

        junctionTableCount++;

        // Add all fields to fields list for EMF containment
        List<RdbmsField> fields = new ArrayList<>();
        fields.add(junctionPk);
        fields.add(field1);
        fields.add(field2);

        return newRdbmsJunctionTableBuilder()
                .withName(junctionName)
                .withUuid(UUID.randomUUID().toString())
                .withSqlName("T_JUNCTION_" + index)
                .withPrimaryKey(junctionPk)
                .withField1(field1)
                .withField2(field2)
                .withFields(fields)
                .build();
    }

    /**
     * Creates an index on a table.
     */
    private void createIndex(RdbmsTable table, int index) {
        // Find a non-primary-key field to index
        List<RdbmsField> indexableFields = new ArrayList<>();
        for (RdbmsField field : table.getFields()) {
            if (field instanceof RdbmsValueField) {
                indexableFields.add(field);
            }
        }

        if (indexableFields.isEmpty()) {
            return;
        }

        RdbmsField fieldToIndex = indexableFields.get(random.nextInt(indexableFields.size()));

        RdbmsIndex rdbmsIndex = newRdbmsIndexBuilder()
                .withName(table.getName() + "#idx_" + index)
                .withUuid(UUID.randomUUID().toString())
                .withSqlName("IDX_" + table.getSqlName() + "_" + index)
                .withFields(fieldToIndex)
                .build();

        table.getIndexes().add(rdbmsIndex);
        indexCount++;
    }

    /**
     * Counts total fields across all tables.
     */
    private int countFields() {
        int count = 0;
        for (RdbmsTable table : tables) {
            count += table.getFields().size();
            if (table.getPrimaryKey() != null) {
                count++; // Primary key is separate from fields list
            }
        }
        return count;
    }
}
