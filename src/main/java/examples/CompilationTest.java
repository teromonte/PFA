package examples;

public class CompilationTest {
    @FunctionalInterface
    interface IntFunction {
        int applyFn(int x);
        default public int applyConstantFn() {
            return 1;
        }
    }
    public static void main(String[] args) {
        final int factor = 2;
        IntFunction f = (int n) -> n * factor, f0 = n -> 2 * n * factor;
        System.out.println(f.applyFn(2017));
        System.out.println(f0.applyFn(2017));
        Runnable ending = () -> System.out.println("That's the end, my friend!");
        ending.run();
    }
}
