// "Replace 'Integer.class' with 'String.class'" "true-preview"
import java.util.*;

class Demo {
  native static <T> List<T> filterIsInstance(Collection<?> collection, Class<? extends T> aClass);

  void test(List<?> list) {
    List<String> stringsSync = Collections.synchronizedList(filterIsInstance(list, String.class));
  }
}