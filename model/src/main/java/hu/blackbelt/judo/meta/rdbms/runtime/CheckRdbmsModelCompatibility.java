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

import hu.blackbelt.judo.meta.rdbms.*;
import hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;

import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsCloneUtil.cloneRdbms;
import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsIncremental.transformRdbmsIncrementalModel;
import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel.buildRdbmsModel;
import static hu.blackbelt.judo.meta.rdbms.support.RdbmsModelResourceSupport.rdbmsModelResourceSupportBuilder;

public class CheckRdbmsModelCompatibility {
    private static Logger log = LoggerFactory.getLogger(CheckRdbmsModelCompatibility.class);

    private CheckRdbmsModelCompatibility() {
    }

    private static RdbmsModelResourceSupport getIncremental(RdbmsModel current, RdbmsModel candidate, String dialect, boolean useXmiId) throws SQLException {
        RdbmsModel incrementalRdbmsModel = buildRdbmsModel().build();

        try {
            transformRdbmsIncrementalModel(cloneRdbms(current, "base", useXmiId),
                    cloneRdbms(candidate, "new", useXmiId), incrementalRdbmsModel, dialect, false);
        } catch (IOException e) {
            throw new IllegalStateException("Could not load RDBMS model", e);
        } catch (RdbmsModel.RdbmsValidationException e) {
            throw new IllegalStateException("Invalid RDBMS model", e);
        } catch (Exception e) {
            throw new IllegalStateException("Error on execution", e);
        }

        RdbmsModelResourceSupport incremental = rdbmsModelResourceSupportBuilder()
                .resourceSet(incrementalRdbmsModel.getResourceSet())
                .uri(org.eclipse.emf.common.util.URI.createURI("rdbms-incremental"))
                .build();

        return incremental;
    }

    public static void printReport(RdbmsOperationMeta rdbmsOperation, StringBuilder sb) {
        if (rdbmsOperation.getIncrementalModel().getTableOperations().size() > 0) {
            sb.append("DATABASE HAVE TO BE UPDATED!\n\n");
            for (RdbmsTableOperation operation : rdbmsOperation.getIncrementalModel().getTableOperations()) {
                if (operation instanceof RdbmsCreateTableOperation) {
                    RdbmsCreateTableOperation rdbmsCreateTableOperation = (RdbmsCreateTableOperation) operation;
                    sb.append("\nCreate table operation: " +
                            rdbmsCreateTableOperation.getTable().getName() + " - " +
                            rdbmsCreateTableOperation.getTable().getSqlName());
                } else if (operation instanceof RdbmsDeleteFieldOperation) {
                    RdbmsDeleteTableOperation rdbmsDeleteTableOperation = (RdbmsDeleteTableOperation) operation;
                    sb.append("\nDelete table operation: " +
                            rdbmsDeleteTableOperation.getTable().getName() + " - " +
                            rdbmsDeleteTableOperation.getTable().getSqlName());
                } else if (operation instanceof RdbmsModifyTableOperation) {
                    RdbmsModifyTableOperation rdbmsModifyTableOperation = (RdbmsModifyTableOperation) operation;
                    sb.append("\nModifiy table operation: " +
                            rdbmsModifyTableOperation.getTable().getName() + " - " +
                            rdbmsModifyTableOperation.getTable().getSqlName() +
                            "\n\tName changed: " + rdbmsModifyTableOperation.isNameChanged());
                    for (RdbmsCreateFieldOperation createFieldOperation : rdbmsModifyTableOperation.getCreateFieldOperations()) {
                        sb.append("\n\tCreate field: " + createFieldOperation.getField().getName() + " - " +
                                createFieldOperation.getField().getSqlName());
                    }
                    for (RdbmsDeleteFieldOperation deleteFieldOperation : rdbmsModifyTableOperation.getDeleteFieldOperations()) {
                        sb.append("\n\tDelete field: " + deleteFieldOperation.getField().getName() + " - " +
                                deleteFieldOperation.getField().getSqlName());
                    }
                    for (RdbmsModifyFieldOperation modifyFieldOperation : rdbmsModifyTableOperation.getModifyFieldOperations()) {
                        sb.append("\n\tModify field: " + modifyFieldOperation.getField().getName() + " - " +
                                modifyFieldOperation.getField().getSqlName() +
                                "\n\t\tName changed:      " + modifyFieldOperation.isNameChanged() +
                                "\n\t\tSize changed:      " + modifyFieldOperation.isSizeChanged() +
                                "\n\t\tType changed:      " + modifyFieldOperation.isTypeChanged() +
                                "\n\t\tMandatory changed: " + modifyFieldOperation.isMandatoryChanged()
                        );
                    }
                }
            }
            sb.append("\n\n");
        }
    }

    public static boolean isRdbmsModelIdentical(RdbmsModel current, RdbmsModel candidate, String dialect, StringBuilder reportBuilder, boolean useXmiId) throws SQLException {

        RdbmsModelResourceSupport incremental = getIncremental(current, candidate, dialect, useXmiId);

        // Make diff and check there is any change in model. It there is have to stop the run.
        RdbmsOperationMeta rdbmsOperation = incremental.getStreamOfRdbmsRdbmsOperationMeta()
                .findFirst().orElseThrow(() -> new IllegalStateException("Could not get RDBMS Operation meta"));

        StringBuilder sb = reportBuilder;
        if (sb == null) {
            sb = new StringBuilder();
        }
        printReport(rdbmsOperation, sb);
        if (reportBuilder == null && sb.toString().length() > 0) {
            log.error(sb.toString());
        }
        return rdbmsOperation.getIncrementalModel().getTableOperations().size() == 0;
    }
}
