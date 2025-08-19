package hu.blackbelt.judo.meta.rdbms.runtime;

/*-
 * #%L
 * Judo :: RDBMS :: Schema :: Maven :: Incremental
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

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static hu.blackbelt.judo.meta.rdbms.runtime.RdbmsModel.SaveArguments.rdbmsSaveArgumentsBuilder;

public class RdbmsModelStreamProvider {
    private static Logger log = LoggerFactory.getLogger(RdbmsModelStreamProvider.class);

    public static InputStream getStreamsFromRdbmsModel(RdbmsModel rdbmsModelModel) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            rdbmsModelModel.saveRdbmsModel(rdbmsSaveArgumentsBuilder().validateModel(false)
                    .outputStream(byteArrayOutputStream).build());
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        } catch (RdbmsModel.RdbmsValidationException | IOException e) {
            log.error("RDBMS error", e);
        }
        return null;
    }
}
