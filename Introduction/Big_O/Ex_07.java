package Big_O;

// Run time: O(N^2)
// The inner loop runs N times and is called N times
public class Ex_07 {
    public static void printPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.println(array[i] + ", " + array[j]);
            }
        }
    }

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5};
        printPairs(array);
    }
}
