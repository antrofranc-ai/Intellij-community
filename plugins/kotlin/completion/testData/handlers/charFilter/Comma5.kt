// FIR_COMPARISON
// FIR_IDENTICAL
fun foo(p1: Int?, p2: Int) { }

fun bar(nullable: Int?) {
    foo(null<caret>)
}

// INVOCATION_COUNT: 0
// ELEMENT: *
// CHAR: ','
