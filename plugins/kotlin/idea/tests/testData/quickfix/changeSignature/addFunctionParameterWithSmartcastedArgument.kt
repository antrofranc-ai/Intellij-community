// "Add parameter to function 'doSmthWithChild'" "true"
// DISABLE-ERRORS

interface Parent
interface Child : Parent

fun doSmthWithChild(a: Child) {}

fun foobar(parent: Parent) {
    if (parent is Child) {
        doSmthWithChild(parent, <caret>123)
    }
}
