package Big_O;

/*
 * The following code performs integer division.
 * What is its runtime (assume a and b are both positive)?
 */

public class Q_04 {
// Performs integer division
// Run time: O(a/b)
// The loop iterates a/b times
    private static int div(int a, int b) {
        int count = 0;
        int sum = b;
        while (sum <= a) {
            sum += b;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(div(10, 2));
    }
}
