// WITH_STDLIB
fun test(set: Set<Int>): Set<Int> {
    return if (set.isNotEmpty<caret>()) {
        set
    } else {
        setOf(1)
    }
}