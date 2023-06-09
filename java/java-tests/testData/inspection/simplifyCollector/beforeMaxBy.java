// "Use 'Collectors.toConcurrentMap()' collector" "true"
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {
  public static void main(String[] args) {
    List<String> input = Arrays.asList("a", "bbb", "cc", "ddd", "  x", "ee");
    Map<Integer, String> map3 = input.stream().collect(Collectors.groupingB<caret>yConcurrent(String::length, Collectors
      .collectingAndThen(Collectors.maxBy(String::compareTo), Optional::get)));
    System.out.println(map3);
  }
}