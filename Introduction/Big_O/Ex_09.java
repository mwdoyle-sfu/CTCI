package Big_O;

public class Ex_09 {
// Notice there are now 2 separate arrays
// You may think the runtime is O(N^2). It is a common mistake.
// It is actually O(ab)
    public static void printUnorderedPairs(int[] arrayA, int[] arrayB) {
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                // The if-statement is O(1)
                if (arrayA[i] < arrayB[j]) {
                    System.out.println(arrayA[i] + "," + arrayB[j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int arrayA[] = {0, 1, 2, 3, 4};
        int arrayB[] = {5, 6, 7};
        printUnorderedPairs(arrayA, arrayB);
    }
}
