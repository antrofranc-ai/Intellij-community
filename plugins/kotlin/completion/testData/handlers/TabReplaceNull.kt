fun foo(s: String){ }

fun String.bar(sss: String) {
    foo(<caret>null)
}

// ELEMENT: sss
// CHAR: \t