// "Create local variable 'xyz'" "true-preview"
interface Other<T> {
  void add(int x, T y);
  void add(T y);
}
class A {
    public void foo(Other<String> other) {
      other.add(x<caret>yz);
    }
}