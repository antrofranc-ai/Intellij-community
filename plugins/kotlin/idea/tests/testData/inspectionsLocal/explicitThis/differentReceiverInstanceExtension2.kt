// WITH_STDLIB
// PROBLEM: none

open class Foo

class SubFoo : Foo()

val Foo.bar: String get() = ""

fun Foo.func() = Foo().apply {
    <caret>this@func.bar
}
