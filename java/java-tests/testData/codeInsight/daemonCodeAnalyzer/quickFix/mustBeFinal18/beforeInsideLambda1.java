// "Copy 'a' to effectively final temp variable" "true-preview"
class Test {
    public void test() {
        int a = 1;
        a = 2;
        Runnable r = () -> {
            System.out.println(<caret>a);
        };
    }
}
