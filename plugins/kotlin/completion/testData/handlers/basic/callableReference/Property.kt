// FIR_IDENTICAL
// FIR_COMPARISON
val prop: Int = 0

class C {
    fun foo() {
        val v = ::<caret>
    }
}

// ELEMENT: prop
