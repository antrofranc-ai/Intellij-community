// WITH_STDLIB
fun test(b: Boolean) {
    val list1 = mutableListOf(1)
    val list2 = mutableListOf(2)

    if (b) <caret>{list1} else {list2}.add(3)
}