// PROBLEM: none
// WITH_STDLIB

class Bar(var foo: Int = 1)

class Test(var foo: Int = 2) {
    fun test() {
        Bar().apply {
            this.foo = <caret>this@Test.foo
        }
    }
}