// FIR_COMPARISON
// FIR_IDENTICAL
fun returnFun() {}

fun usage() {
    if (true) re<caret>
}

// ORDER: return
// ORDER: returnFun
