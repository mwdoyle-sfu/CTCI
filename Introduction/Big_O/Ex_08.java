package Big_O;

public class Ex_08 {

// Notice the second loop starts at i + 1
// Notice j runs through N - 1, then N - 2, then N - 3 steps
// The sum of 1 through N -1 is (N(N-1)/2)
// Run time is O(N^2)
    public static void printUnorderedPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                System.out.println(array[i] + "," + array[j]);
            }
        }
    }


    public static void main(String[] args) {
        int array[] = {0, 1, 2, 3, 4, 5, 6, 7};
        printUnorderedPairs(array);
    }
}
