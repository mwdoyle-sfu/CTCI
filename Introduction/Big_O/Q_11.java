package Big_O;

/*
 * The following code prints all strings of length k where the characters are in sorted
 * order. It does this by generating all strings of length k and then checking if each
 * is sorted. What is its runtime?
 */

public class Q_11 {
    // where k is the length of the string and c is the number of characters in the alphabet
    // runtime is O(kc^k)
    private static int numChars = 26;

    private static void printSortedStrings(int remaining) {
        printSortedStrings(remaining, "");
    }

    private static void printSortedStrings(int remaining, String prefix) {
        // building each string takes O(c^k) time
        if (remaining == 0) {
            if (isInOrder(prefix)) {
                System.out.println(prefix);
            }
        } else {
            for (int i = 0; i < numChars; i++) {
                char c = ithLetter(i);
                printSortedStrings(remaining - 1, prefix + c);
            }
        }
    }

    private static boolean isInOrder(String s) {
        // checking each string is sorted takes O(k) time
        for (int i = 1; i < s.length(); i++) {
            int prev = ithLetter(s.charAt(i - 1));
            int curr = ithLetter(s.charAt(i));
            if (prev > curr) {
                return false;
            }
        }
        return true;
    }

    private static char ithLetter(int i) {
        return (char) (((int) 'a') + i);
    }

    public static void main(String[] args) {
        printSortedStrings(3);
    }
}
