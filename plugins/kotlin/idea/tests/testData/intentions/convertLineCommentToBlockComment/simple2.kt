// AFTER-WARNING: Variable 'bar' is never used
// AFTER-WARNING: Variable 'foo' is never used
fun test() {
    val foo = 1

    // comment1
    // comment2<caret>
    // comment3
    val bar = 1
}