// WITH_STDLIB

fun foo(map: MutableMap<Int, String>) {
    map.<caret>put(42, "foo")
}