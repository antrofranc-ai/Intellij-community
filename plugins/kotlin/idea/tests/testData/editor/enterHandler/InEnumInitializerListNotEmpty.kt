// SET_TRUE: ALIGN_MULTILINE_EXTENDS_LIST

interface A1

enum class EnumTest {
    ENTRY(), <caret>A1
}

// WITHOUT_CUSTOM_LINE_INDENT_PROVIDER