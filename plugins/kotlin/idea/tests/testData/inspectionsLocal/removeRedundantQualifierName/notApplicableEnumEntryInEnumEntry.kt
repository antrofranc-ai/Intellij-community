// PROBLEM: none
// WITH_STDLIB
fun main() {
    MyEnum.B.foo()
}

enum class MyEnum {
    A {
        override fun foo() {
            println("A")
        }
    },
    B {
        override fun foo() {
            println("B")
            <caret>A.foo()
        }
    };

    abstract fun foo()
}