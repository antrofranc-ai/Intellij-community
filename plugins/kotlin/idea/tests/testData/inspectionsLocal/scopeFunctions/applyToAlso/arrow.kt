// WITH_STDLIB
// FIX: Convert to 'also'

fun foo() {
    "".<caret>apply {
        ->
        println(this)
    }
}
