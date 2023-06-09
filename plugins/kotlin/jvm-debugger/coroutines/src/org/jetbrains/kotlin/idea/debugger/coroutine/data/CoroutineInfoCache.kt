// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

package org.jetbrains.kotlin.idea.debugger.coroutine.data

class CoroutineInfoCache(
    val cache: MutableList<CoroutineInfoData> = mutableListOf(), var state: CacheState = CacheState.INIT
) {
    fun ok(infoList: List<CoroutineInfoData>): CoroutineInfoCache {
        cache.clear()
        cache.addAll(infoList)
        state = CacheState.OK
        return this
    }

    fun ok(): CoroutineInfoCache {
        cache.clear()
        state = CacheState.OK
        return this
    }

    fun fail(): CoroutineInfoCache {
        cache.clear()
        state = CacheState.FAIL
        return this
    }

    fun isOk(): Boolean {
        return state == CacheState.OK
    }
}

enum class CacheState {
    OK, FAIL, INIT
}
