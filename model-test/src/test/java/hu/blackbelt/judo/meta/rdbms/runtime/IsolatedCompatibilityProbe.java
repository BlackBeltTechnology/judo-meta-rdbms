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

import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsIncrementalTestSupport.loadFixture;

/**
 * Code run through a class loader which hides Epsilon ({@link CheckRdbmsModelCompatibilityTest}); it only uses classes
 * from the production code and the JDK in its public API, so the result crosses the class loader boundary as text.
 */
public class IsolatedCompatibilityProbe {

    private IsolatedCompatibilityProbe() {
    }

    /** {@code isRdbmsModelIdentical(m, m)} and {@code (m, m + column)}; returns {@code "<same>|<changed>|<report>"}. */
    public static String run() throws Exception {
        RdbmsModel current = loadFixture("initial-rdbms_hsqldb");
        RdbmsModel same = loadFixture("initial-rdbms_hsqldb");
        boolean identical = CheckRdbmsModelCompatibility.isRdbmsModelIdentical(current, same, "hsqldb", null, false);

        RdbmsModel stored = loadFixture("initial-rdbms_hsqldb");
        RdbmsModel candidate = loadFixture("initial-rdbms_hsqldb");
        CheckRdbmsModelCompatibilityTest.addColumn(candidate);
        StringBuilder report = new StringBuilder();
        boolean changed = CheckRdbmsModelCompatibility.isRdbmsModelIdentical(stored, candidate, "hsqldb", report, false);
        return identical + "|" + changed + "|" + report;
    }

    /** The same check through the ETL; needs Epsilon. */
    @SuppressWarnings("deprecation")
    public static String runEtl() throws Exception {
        RdbmsModel incremental = RdbmsModel.buildRdbmsModel().build();
        RdbmsIncremental.transformRdbmsIncrementalModel(loadFixture("initial-rdbms_hsqldb"),
                loadFixture("initial-rdbms_hsqldb"), incremental, "hsqldb", false);
        return "etl-ran";
    }
}
