// WITH_STDLIB
// PROBLEM: none

class Foo {
    val s = ""

    fun test() {
        Bar().apply {
            <caret>this@Foo.s
        }
    }
}

class Bar {
    val s = ""
}