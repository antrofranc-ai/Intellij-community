// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.jsonUtils

import com.google.gson.JsonObject

fun JsonObject.getString(name: String): String {
    return getNullableString(name) ?: throw IllegalStateException("Member with name '$name' is expected in '$this'")
}

fun JsonObject.getNullableString(name: String): String? {
    return this[name]?.asString
}
