// "Replace '(FooBar)foo' with 'foobar2'" "true-preview"

class FooBar {
  public int baz;

  int method(Object foo) {
    FooBar foobar = (FooBar)foo;
    foobar = null;
    FooBar foobar2 = (FooBar)foo;
    return ((FooBar<caret>)foo//comment
            ).baz;
  }
}