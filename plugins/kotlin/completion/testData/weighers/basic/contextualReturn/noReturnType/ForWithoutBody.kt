// FIR_COMPARISON
// FIR_IDENTICAL
fun returnFun() {}

fun usage() {
    for (i in 1..10) re<caret>
}

// ORDER: returnFun
// ORDER: return
