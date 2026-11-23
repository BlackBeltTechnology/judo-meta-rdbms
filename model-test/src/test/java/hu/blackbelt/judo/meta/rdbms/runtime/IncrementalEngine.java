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

/**
 * Selects the incremental model engine in parameterized tests (pattern of {@link ValidatorType}).
 * {@link #ETL} is the Epsilon oracle {@link RdbmsIncremental}; {@link #JAVA} is
 * {@link RdbmsIncrementalTransformation}.
 */
public enum IncrementalEngine {
    ETL {
        @SuppressWarnings("deprecation")
        @Override
        public void transform(RdbmsModel previous, RdbmsModel current, RdbmsModel incremental, String dialect,
                              boolean ignoreReview) throws Exception {
            RdbmsIncremental.transformRdbmsIncrementalModel(previous, current, incremental, dialect, true, ignoreReview);
        }
    },
    JAVA {
        @Override
        public void transform(RdbmsModel previous, RdbmsModel current, RdbmsModel incremental, String dialect,
                              boolean ignoreReview) {
            RdbmsIncrementalTransformation.transform(previous, current, incremental, dialect, ignoreReview);
        }
    };

    public abstract void transform(RdbmsModel previous, RdbmsModel current, RdbmsModel incremental, String dialect,
                                   boolean ignoreReview) throws Exception;
}
