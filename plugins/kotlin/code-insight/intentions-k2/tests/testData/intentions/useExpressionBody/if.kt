// // IS_APPLICABLE: true

fun abs(x: Int): Int {
    // No highlighting here
    <caret>return if (x > 0) {
        x
    }
    else {
        -x
    }
}