// "Replace with array call" "true"

annotation class Some(vararg val strings: String)

@Some(strings = <caret>"value")
class My
