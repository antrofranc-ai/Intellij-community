// WITH_STDLIB
fun foo() {
    // check that original formatting of "x+1" and "1 .. 4" is preserved
// AFTER-WARNING: The expression is unused
    <caret>for (x in 1 .. 4) {
        x
        x+1
    }
}