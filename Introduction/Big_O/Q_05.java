package Big_O;

/*
 *
 * The following code computes the [integer) square root of a number.
 * If the number is not a perfect square (there is no integer square root), then it returns -1
 * It does this by successive guessing. If n is 100, it first guesses 5O.
 * Too high? Try something lower - halfway between 1 and 5O. What is its runtime?
 *
 */

public class Q_05 {
    // This is similar to a binary search which has O(log n) runtime
    // Notice that the range is divided by two on each iteration

    private static int sqrt(int n) {
        return sqrt_helper(n, 1, n);
    }

    private static int sqrt_helper(int n, int min, int max) {
        if (max < min) return -1;   // no square root

        int guess = (min + max) / 2;
        if (guess * guess == n) {   // found it
            return guess;
        } else if (guess * guess < n) { // too low
            return sqrt_helper(n, guess + 1, max); // try higher
        } else { // too high
            return sqrt_helper(n, min, guess - 1); // try lower
        }
    }

    public static void main(String[] args) {
        System.out.println(sqrt(25));
    }
}
