package ch.cyberduck.core.sftp;

/*
 * Copyright (c) 2002-2013 David Kocher. All rights reserved.
 * http://cyberduck.ch/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * Bug fixes, suggestions and comments should be sent to feedback@cyberduck.ch
 */

import ch.cyberduck.core.Path;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.preferences.Preferences;
import ch.cyberduck.core.preferences.PreferencesFactory;
import ch.cyberduck.core.shared.AppendWriteFeature;
import ch.cyberduck.core.transfer.TransferStatus;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;

import net.schmizz.sshj.sftp.OpenMode;
import net.schmizz.sshj.sftp.RemoteFile;

/**
 * @version $Id$
 */
public class SFTPWriteFeature extends AppendWriteFeature {
    private static final Logger log = Logger.getLogger(SFTPWriteFeature.class);

    private SFTPSession session;

    private Preferences preferences
            = PreferencesFactory.get();

    public SFTPWriteFeature(final SFTPSession session) {
        super(session);
        this.session = session;
    }

    @Override
    public OutputStream write(final Path file, final TransferStatus status) throws BackgroundException {
        try {
            final RemoteFile handle;
            if(status.isAppend()) {
                if(status.isExists()) {
                    // No append flag. Otherwise the offset field of SSH_FXP_WRITE requests is ignored.
                    handle = session.sftp().open(file.getAbsolute(), EnumSet.of(OpenMode.WRITE));
                }
                else {
                    // Allocate offset
                    handle = session.sftp().open(file.getAbsolute(), EnumSet.of(OpenMode.CREAT, OpenMode.WRITE));
                }
            }
            else {
                if(status.isExists() && !status.isRename()) {
                    if(file.isSymbolicLink()) {
                        // Workaround for #7327
                        session.sftp().remove(file.getAbsolute());
                    }
                }
                // A new file is created; if the file already exists, it is opened and truncated.
                handle = session.sftp().open(file.getAbsolute(),
                        EnumSet.of(OpenMode.CREAT, OpenMode.TRUNC, OpenMode.WRITE));
            }
            final int maxUnconfirmedWrites
                    = (int) (status.getLength() / preferences.getInteger("connection.chunksize")) + 1;
            if(log.isInfoEnabled()) {
                log.info(String.format("Skipping %d bytes", status.getOffset()));
            }
            // Open stream at offset
            return handle.new RemoteFileOutputStream(status.getOffset(), maxUnconfirmedWrites) {
                private final AtomicBoolean close = new AtomicBoolean();

                @Override
                public void close() throws IOException {
                    if(close.get()) {
                        log.warn(String.format("Skip double close of stream %s", this));
                        return;
                    }
                    try {
                        super.close();
                    }
                    finally {
                        handle.close();
                        close.set(true);
                    }
                }
            };
        }
        catch(IOException e) {
            throw new SFTPExceptionMappingService().map("Upload {0} failed", e, file);
        }
    }

    @Override
    public boolean temporary() {
        return true;
    }

    @Override
    public boolean random() {
        return true;
    }
}
