// WITH_STDLIB
// AFTER-WARNING: Parameter 'a' is never used

class MyClass {
    fun foo1() = Unit
    fun foo2(a: MyClass) = Unit
    fun foo3() = Unit

    fun foo4(it: MyClass) {
        val a = MyClass()
        a.foo1()
        a.foo3()<caret>
        a.foo2(it)
        a.foo3()
    }
}