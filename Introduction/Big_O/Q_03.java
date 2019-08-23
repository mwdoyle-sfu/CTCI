package Big_O;

/*
 * The following code computes a % b.
 * What is its runtime?
 */

public class Q_03 {
// Computes a % b
// Run time: O(1)
// Does a constant amount of work
    private static int mod(int a, int b) {
        if (b <= 0) {
            return -1;
        }
        int div = a / b;
        return a - div * b;
    }


    public static void main(String[] args) {
        System.out.println(mod(10, 3));
    }
}
