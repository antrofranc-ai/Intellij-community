// WITH_STDLIB

val x = listOf(1, 2, 3).filte<caret>r { it % 2 != 0 }.isEmpty()