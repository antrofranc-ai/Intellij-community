// WITH_STDLIB
// PROBLEM: none
package org.apache.commons.logging

class Foo {
    private val logger = LogFactory.getLog(<caret>Foo::class.java)
}

class Bar

object LogFactory {
    fun getLog(clazz: Class<*>) {}
    fun getLog(name: String?) {}
}