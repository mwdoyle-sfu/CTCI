package Big_O;

/*
* The appendToNew method appends a value to an array by creating a new, longer array and
* returning this longer array. You've used the appendToNew method to create a copyArray
* function that repeatedly calls appendToNew. How long does copying an array take?
*/

public class Q_09 {

    private static int[] copyArray(int[] array) {
        int[] copy = new int[0];
        for (int value: array) {
            // At each iteration the number of copies increases by 1
            // the total time is the sum of (1 + 2 + ... + n) which is n(n+1)/2 or O(n^2)
            // more simply this is n multiplied n times
            copy = appendToNew(copy, value);
        }
        return copy;
    }

    private static int[] appendToNew(int[] array, int value) {
        // copy all elements over to new array
        int[] bigger = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            bigger[i] = array[i];
        }

        // add new element
        bigger[bigger.length -1] = value;
        return bigger;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] copy = copyArray(array);
        for (int x : copy) {
            System.out.println(x);
        }
    }

}
