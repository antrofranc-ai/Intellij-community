// FIR_COMPARISON

fun foo() {
    takeHandler1 {
        takeHandler2({ -> ret<caret> })
    }
}

inline fun takeHandler1(handler: () -> Unit){}
inline fun takeHandler2(handler: () -> String){}

// ELEMENT: return@takeHandler2
