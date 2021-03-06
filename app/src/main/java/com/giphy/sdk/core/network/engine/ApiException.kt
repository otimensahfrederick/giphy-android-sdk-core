/*
 * Created by Bogdan Tirca on 4/19/17.
 * Copyright (c) 2017 Giphy Inc.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.giphy.sdk.core.network.engine

import com.giphy.sdk.core.network.response.ErrorResponse

class ApiException : Exception {

    val errorResponse: ErrorResponse

    constructor(errorResponse: ErrorResponse) {
        this.errorResponse = errorResponse
    }

    constructor(detailMessage: String, errorResponse: ErrorResponse) : super(detailMessage) {
        this.errorResponse = errorResponse
    }
}
