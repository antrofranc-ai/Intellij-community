// SET_TRUE: USE_TAB_CHARACTER
// SET_INT: TAB_SIZE=2
// SET_INT: INDENT_SIZE=2

class A {
	val a = """
		<caret>
	""".trimIndent()
}

// IGNORE_FORMATTER