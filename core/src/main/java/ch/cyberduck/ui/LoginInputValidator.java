package ch.cyberduck.ui;

/*
 * Copyright (c) 2002-2016 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
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
 */

import ch.cyberduck.core.Credentials;
import ch.cyberduck.core.LoginOptions;
import ch.cyberduck.core.Protocol;

public class LoginInputValidator implements InputValidator {
    private final Credentials credentials;
    private final LoginOptions options;

    private Protocol protocol;

    public LoginInputValidator(final Credentials credentials, final Protocol protocol, final LoginOptions options) {
        this.credentials = credentials;
        this.protocol = protocol;
        this.options = options;
    }

    @Override
    public boolean validate() {
        return credentials.validate(protocol, options);
    }

    public void configure(final Protocol protocol) {
        this.protocol = protocol;
    }
}
