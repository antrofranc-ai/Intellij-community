// "Replace with lambda" "true-preview"
import java.util.function.*;
class Test {

  public static Promise<Integer> some() {
    return PromiseUtils.compose(
      new Promise<String>(),
      v -> new Promise<Long>(),
      new Funct<caret>ion<Long, Integer>() {
        @Override
        public Integer apply(Long result) {
          return 0;
        }
      });
  }
}

class Promise<T> {}

class PromiseUtils {
  public static <A, B, C> Promise<C> compose(Promise<A> aPromise, Function<A, Promise<B>> abTransform, Function<B, C> resultTransform) {
    return null;
  }
}