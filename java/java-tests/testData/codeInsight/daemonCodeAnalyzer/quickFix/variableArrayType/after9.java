// "Change field 'myArr' type to 'char[][]'" "true-preview"
class A extends B {
    void m() {
        myArr = new char[][]{{<caret>'a'}};
    }
}

class B {
  protected char[][] myArr;
}