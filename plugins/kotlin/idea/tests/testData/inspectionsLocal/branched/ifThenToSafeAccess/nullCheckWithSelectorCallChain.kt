// WITH_STDLIB

val nullableString: String? = "abc"

val foo = <caret>if (nullableString != null) {
    nullableString.toUpperCase().toLowerCase()
} else {
    null
}