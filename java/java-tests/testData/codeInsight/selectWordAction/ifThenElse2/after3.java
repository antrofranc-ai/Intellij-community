package test;

public class TestClass {

  public void test() {
	  if (true) {
          System.out.println();
	  }
      else if (false) {
          System.out.println();
      }
<selection>      else {
<caret>         System.out.println();
	  }
</selection>  }
}