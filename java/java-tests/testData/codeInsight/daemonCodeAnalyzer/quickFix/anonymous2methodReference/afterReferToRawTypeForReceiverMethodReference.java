// "Replace with method reference" "true-preview"
import java.util.List;
import java.util.function.Function;

class MyTest {

  Function<List<?>, String> TO_TEXT = Object::toString;

}
