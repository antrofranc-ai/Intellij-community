// "Extract if (a)" "true-preview"
class TestThreadInspection {
  void f(boolean a, boolean b, boolean c){
      /*the comment inside redundant parenthesis*/
      //simple end comment
      if (a) {
          System.out.println("a&b");
      } else if (b) {
          System.out.println("a&b");
      } else {
          System.out.println("c");
      }
  }
}