// WITH_STDLIB
// INTENTION_TEXT: "Replace with 'flatMap{}.mapNotNull{}.mapTo(){}'"
// INTENTION_TEXT_2: "Replace with 'asSequence().flatMap{}.mapNotNull{}.mapTo(){}'"
// AFTER-WARNING: Parameter 'p' is never used
fun foo(list: List<String>, target: MutableList<String>) {
    <caret>for (s in list) {
        for (i in s.indices) {
            val v = bar(i) ?: continue
            target.add(v.substring(1))
        }
    }
}

fun bar(p: Int): String? = null