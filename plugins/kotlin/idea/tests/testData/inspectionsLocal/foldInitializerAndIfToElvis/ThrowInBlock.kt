// WITH_STDLIB

fun foo(p: List<String?>) {
    val v = p[0]
    <caret>if (v == null) {
        throw RuntimeException()
    }
}