// WITH_STDLIB
// MIN_JAVA_VERSION: 9
// FIX: Replace with 'mutableSetOf' function

fun test() {
    val a = java.util.Set.of<caret><String>()
}