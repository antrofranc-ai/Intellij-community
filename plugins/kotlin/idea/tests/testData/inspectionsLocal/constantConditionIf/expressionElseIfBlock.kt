// WITH_STDLIB

fun foo(x: Int) {}

fun bar(s: String?) {
    if (s == null) {
        1
    }
    else if (<caret>true) {
        foo(1)
        2
    }
    else {
        3
    }
}