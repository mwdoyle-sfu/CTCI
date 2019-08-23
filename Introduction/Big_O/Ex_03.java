package Big_O;

// Which is faster?
// This one has 2 statements in the loop
// The other has two for loops
// Counting instructions is pointless unless using assembly
public class Ex_03 {
    private static void minAndMax1(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x : array) {
            if (x < min) min = x;
            if (x > max) max = x;
        }
        System.out.println(min + ", " + max);
    }

// Two (non-nested) for loops could be described as O(2N)
// In big O we drop the constants so this function is O(N)
    private static void minAndMax2(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x : array) {
            if (x < min) min = x;
        }
        for (int x : array) {
            if (x > max) max = x;
        }
        System.out.println(min + ", " + max);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 2, 2, 5, -1, 9, 3};
        minAndMax1(array);
        minAndMax2(array);
    }
}
