// FIR_COMPARISON
// FIR_IDENTICAL
fun foo(s: String){ }

fun bar(sss: String) {
    foo(<caret>x.y())
}

// ELEMENT: sss
// CHAR: \t