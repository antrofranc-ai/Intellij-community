// "Replace lambda with method reference" "true-preview"
import java.util.function.Function;

class Bar extends Random {
  public void test(Object obj) {
    Function<Object, String> fn = s -> (String)<caret>s;
  }
}