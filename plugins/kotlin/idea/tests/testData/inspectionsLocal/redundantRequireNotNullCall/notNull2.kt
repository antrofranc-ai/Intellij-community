// WITH_STDLIB
fun test(s: String?) {
    if (s != null) {
        println(1)
        requireNotNull<caret>(s) { "" }
        println(2)
    }
}