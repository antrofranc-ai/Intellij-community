// "Specify supertype" "true"
package a.b.c

interface X

open class Y {
    open fun foo() {}
}

interface Z {
    fun foo() {}
}

class Test : X, Y(), Z {
    override fun foo() {
        <caret>super.foo()
    }
}
