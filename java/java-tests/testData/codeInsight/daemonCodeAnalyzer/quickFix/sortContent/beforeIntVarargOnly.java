// "Sort content" "true-preview"

import java.util.*;

public class Main {
  private static void foo(int... vararg) {}

  private void test() {
    foo(1, <caret>4, 3);
  }
}
