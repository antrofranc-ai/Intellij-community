// "Remove redundant 'if' statement" "true"
// WITH_STDLIB
fun foo() {
    listOf(1,2,3).find {
        <caret>if (it > 0) {
            return@find true
        } else {
            return@find false
        }
    }
}