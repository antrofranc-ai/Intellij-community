fun bar(o: Any): String {
    val v: String = o as <caret>
    return ""
}

// AUTOCOMPLETE_SETTING: true