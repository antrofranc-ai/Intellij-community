// "Apply conversion '.toArray(new java.util.List[0])'" "true-preview"

import java.util.*;
class Generic {
  List<String>[] foo() {
    Set<List<String>> set = new HashSet<>();
    List<String>[] <caret>arr = set;
    return arr;
  }
}