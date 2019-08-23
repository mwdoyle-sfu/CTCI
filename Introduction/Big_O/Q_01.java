package Big_O;

/*
 * The following code computes the product of a and b.
 * What is its runtime?
 *
 */

public class Q_01 {
// Prints the product of a and b by adding a b times
// The for loop runs b times
// Run time: O(b)
    public static int product(int a, int b) {
        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum += a;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(product(3, 4));
    }
}
