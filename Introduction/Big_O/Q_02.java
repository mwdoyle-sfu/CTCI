package Big_O;

/*
 * The following code computes a^b
 * What is its runtime?
 *
 */

public class Q_02 {
// This prints a^b
// Run time: O(b) the recursive code iterates through b calls
    private static int power(int a, int b) {
        if (b < 0) {
            return 0; // error
        } else if (b == 0) {
            return 1;
        } else {
            return a * power(a, b -1);
        }
    }

    public static void main(String[] args) {
        System.out.println(power(2,3));
    }
}
