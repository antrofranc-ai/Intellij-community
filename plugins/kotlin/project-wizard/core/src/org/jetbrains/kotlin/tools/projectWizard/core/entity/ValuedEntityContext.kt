// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.jetbrains.kotlin.tools.projectWizard.core.entity

abstract class ValuedEntityContext<E : Entity> {
    protected val values = mutableMapOf<String, Any>()

    @Suppress("UNCHECKED_CAST")
    operator fun <V : Any> get(entity: E) =
        values[entity.path] as? V

    open operator fun set(entity: E, value: Any) {
        values[entity.path] = value
    }

}

