package Big_O;

public class Ex_10 {
// Notice the inner for loop goes to 10,000
// This is just a constant unit of work
// This means run time is still O(ab)
    public static void printUnorderedPairs(int[] arrayA, int[] arrayB) {
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                for (int k = 0; k < 1000; k++) {
                    System.out.println(arrayA[i] + "," + arrayB[j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arrayA = {0, 1, 2, 3};
        int[] arrayB = {4, 5, 6};
        printUnorderedPairs(arrayA, arrayB);
    }
}
