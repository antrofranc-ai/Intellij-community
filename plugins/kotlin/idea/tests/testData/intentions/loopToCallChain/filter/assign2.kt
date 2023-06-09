// WITH_STDLIB
// INTENTION_TEXT: "Replace with 'filter{}'"
// IS_APPLICABLE_2: false
import java.util.ArrayList

fun foo(list: List<String>, p: Int): List<String> {
    return if (p > 0) {
        val result = ArrayList<String>()
        <caret>for (s in list) {
            if (s.length > 0) {
                result.add(s)
            }
        }
        result
    }
    else {
        emptyList()
    }
}