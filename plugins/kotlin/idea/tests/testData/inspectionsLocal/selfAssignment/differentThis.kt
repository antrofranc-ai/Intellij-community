// PROBLEM: none
// WITH_STDLIB

class Test {
    var foo = 1

    fun test() {
        with (Test()) {
            this@Test.foo = <caret>foo // Different receiver
        }
    }
}