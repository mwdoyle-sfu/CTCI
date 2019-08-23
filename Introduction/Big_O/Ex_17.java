package Big_O;

public class Ex_17 {
// Remember O(branches^depth)
// There are two branches per call with a depth of N
// Run time: O(2^n) or more exactly O(1.6^n)
// Note that algorithms with recursive calls usually have exponential run time
    private static int fib(int n) {
        // depth of N
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        // Two branches per call
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.out.println(i + ": " + fib(i));
        }
    }
}
