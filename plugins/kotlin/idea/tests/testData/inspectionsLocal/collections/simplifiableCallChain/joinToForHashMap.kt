// PROBLEM: none
// WITH_STDLIB

val x = hashMapOf(1 to 2, 3 to 4).<caret>map { (key, value) -> key + value }.joinToString()