@file:Suppress("UNUSED_PARAMETER")

package sample

actual interface <!LINE_MARKER("descr='Has expects in common-2 module'")!>C<!> {
    actual fun <!LINE_MARKER("descr='Has expects in common-2 module'")!>common_2_C<!>()
    fun jvm_C()
}

actual interface <!LINE_MARKER("descr='Has expects in common-1 module'")!>B<!> : A {
    actual fun <!LINE_MARKER("descr='Has expects in common-1 module'")!>common_1_B<!>()
    fun jvm_B()
}

typealias A_jvm_Alias = A
typealias B_jvm_Alias = B
typealias C_jvm_Alias = C

fun take_A_jvm(func: (A) -> Unit) {}
fun take_B_jvm(func: (B) -> Unit) {}
fun take_C_jvm(func: (C) -> Unit) {}

fun take_A_alias_jvm(func: (A_jvm_Alias) -> Unit) {}
fun take_B_alias_jvm(func: (B_jvm_Alias) -> Unit) {}
fun take_C_alias_jvm(func: (C_jvm_Alias) -> Unit) {}
