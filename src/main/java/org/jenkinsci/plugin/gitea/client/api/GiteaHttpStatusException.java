/*
 * The MIT License
 *
 * Copyright (c) 2018, CloudBees, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jenkinsci.plugin.gitea.client.api;

import java.io.IOException;
import org.apache.commons.lang.StringUtils;

/**
 * A richer {@link IOException} that reflects the status code of a response.
 *
 * @since 1.0.5
 */
public class GiteaHttpStatusException extends IOException {

    private final int statusCode;
    private final String statusMessage;

    public GiteaHttpStatusException(int statusCode, String statusMessage) {
        this(statusCode, statusMessage, null, null);
    }

    public GiteaHttpStatusException(int statusCode, String statusMessage, Throwable cause) {
        this(statusCode, statusMessage, null, cause);
    }

    public GiteaHttpStatusException(int statusCode, String statusMessage, String requestBody) {
        this(statusCode, statusMessage, requestBody, null);
    }

    public GiteaHttpStatusException(int statusCode, String statusMessage, String responseBody, Throwable cause) {
        super("HTTP " + statusCode + "/" + statusMessage + (StringUtils.isNotBlank(responseBody)
                ? "\n" + responseBody
                : ""), cause);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
}
