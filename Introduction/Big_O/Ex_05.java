package Big_O;

public class Ex_05 {

// Because of the two calls you may think space complexity is O(N^2).
// Its not.
// Run time: O(branches^depth)
// Space complexity: O(N): Only O(N) branches exists at a time
    private static int f(int n) {
        if (n <= 1) {
            return 1;
        }
        return f(n - 1) + f(n - 1);
    }

    public static void main(String[] args) {
        f(1);
    }
}
