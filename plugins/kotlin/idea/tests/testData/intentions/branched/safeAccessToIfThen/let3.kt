// WITH_STDLIB

fun foo(a: Int, b: Int?): Int? {
    return b<caret>?.let { a + b }
}