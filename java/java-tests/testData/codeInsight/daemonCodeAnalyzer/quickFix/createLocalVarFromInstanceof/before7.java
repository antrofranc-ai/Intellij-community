// "Insert '(String)s' declaration" "true-preview"
class C {
    void f() {
        String s = "";
        if (s instanceof String) {
            <caret>
        }
    }
}
