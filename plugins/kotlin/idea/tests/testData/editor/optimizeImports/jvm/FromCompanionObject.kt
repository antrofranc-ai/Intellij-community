// FIR_COMPARISON
import java.util.ArrayList

class B {
    companion object {
        fun foo(){}

        val property = 0

        class Nested
    }

    fun f(): Nested {
        foo()
        property
    }
}