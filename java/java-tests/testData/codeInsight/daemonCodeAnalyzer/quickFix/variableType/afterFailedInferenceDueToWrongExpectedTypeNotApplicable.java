// "Change variable 'foo' type to 'String'" "true-preview"

import java.util.List;
import java.util.Set;

class MyClass {
  public static void sort(final List<String> list) {
    String foo = (findStart(list));
  }

  private static <V> V findStart(List<V> result) {
    return result.get(0);
  }

}