// WITH_STDLIB
class SomeException : RuntimeException()
fun foo(): Int = 1

fun test(x: Boolean, y: Boolean) {
    if (x) throw SomeException()
    else if (y) return
    else<caret> foo()
}