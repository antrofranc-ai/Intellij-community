// WITH_STDLIB
// FIX: Change call to 'map'

fun foo(c: Collection<String>) {
    c.<caret>mapNotNull {
        return@mapNotNull ""
    }
}