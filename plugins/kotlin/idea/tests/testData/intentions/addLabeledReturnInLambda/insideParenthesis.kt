// WITH_STDLIB
// INTENTION_TEXT: "Add 'return@find'"

fun foo() {
    listOf(1,2,3).find({
        <caret>true
    })
}