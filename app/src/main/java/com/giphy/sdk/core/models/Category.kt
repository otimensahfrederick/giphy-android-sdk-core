/*
 * Created by Bogdan Tirca on 4/25/17.
 * Copyright (c) 2017 Giphy Inc.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.giphy.sdk.core.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Category(
        var name: String? = null,

        @SerializedName("name_encoded")
        var nameEncoded: String? = null,

        var gif: Media? = null,

        @SerializedName("subcategories")
        val subCategories: List<Category>? = null,

        var encodedPath: String? = null
) : Parcelable
