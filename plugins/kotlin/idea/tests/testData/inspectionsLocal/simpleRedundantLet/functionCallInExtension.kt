// PROBLEM: none
// WITH_STDLIB

fun foo(s: String, i: Int) = s.length + i

fun String.baz(): Int {
    return let<caret> { foo(it, 1) }
}