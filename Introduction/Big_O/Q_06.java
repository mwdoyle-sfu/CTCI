package Big_O;

/*
 * The following code computes the [integer) square root of a number. If the number is not
 * a perfect square (there is no integer square root), then it returns -1. It does this by
 * trying increasingly large numbers until it finds the right value (or is too high).
 * What is its runtime?
 */

public class Q_06 {
    // The for loop stops at sqrt(n) or when guess is > sqrt(n)
    // This means the runtime is O(sqrt(n))
    private static int sqrt(int n) {
        for (int guess = 1; guess * guess <= n; guess++) {
            if (guess * guess == n) {
                return guess;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(25));
    }
}
/*
* Q7.
* If a binary search tree is not balanced, how long might it take (worst case)
* to find an element in it? O(n) the max time to find an element is the depth of the tree
* and the tree may be a straight downward list with depth n
*
* Q8.
* You are looking for a specific value in a binary tree, but the tree is not a binary
* search tree. What is the time complexity of this? without ordering we may need to search
* each node
*/
