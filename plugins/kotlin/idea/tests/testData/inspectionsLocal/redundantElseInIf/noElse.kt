// PROBLEM: none
// WITH_STDLIB
class SomeException : RuntimeException()

fun test(x: Boolean, y: Boolean) {
    if (x) {
        throw SomeException()
    } else<caret> if (y) {
        return
    }
}