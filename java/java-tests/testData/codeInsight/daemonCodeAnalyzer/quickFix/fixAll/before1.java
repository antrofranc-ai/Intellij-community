// "Fix all 'Constant values' problems in file" "true"
public class Test {
  void foo() {
    int k = 0;
    int i = 0;
    if (i <caret>== k) {}
    if (i == k) {}
    if (i == k) {}
    if (i == k) {}
    if (i == k) {}
    if (i == k) {}
  }
}