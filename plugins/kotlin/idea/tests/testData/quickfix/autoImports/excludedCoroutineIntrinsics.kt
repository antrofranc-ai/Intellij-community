// "Import" "false"
// WITH_STDLIB
// LANGUAGE_VERSION: 1.2
// ACTION: Create function 'suspendCoroutineOrReturn'
// ACTION: Rename reference
// ERROR: Unresolved reference: suspendCoroutineOrReturn

fun some() {
    suspendCoroutineOrReturn<caret> {}
}
