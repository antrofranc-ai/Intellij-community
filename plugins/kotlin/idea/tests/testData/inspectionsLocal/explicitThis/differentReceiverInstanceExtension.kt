// WITH_STDLIB
// PROBLEM: none

class Foo {
    fun test() {
        Foo().apply {
            <caret>this@Foo.s()
        }
    }
}

fun Foo.s() {}