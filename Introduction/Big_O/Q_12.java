package Big_O;

/*
* The following code computes the intersection (the number of elements in common) of two
* arrays. It assumes that neither array has duplicates. It computes the intersection by
* sorting one array (array b) and then iterating through array a checking (via binary
* search) if each value is in b. What is its runtime?
*/

public class Q_12 {

    public static void mergesort(int[] array) {
        int[] helper = new int[array.length];
        mergesort(array, helper, 0, array.length - 1);
    }

    public static void mergesort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergesort(array, helper, low, middle); // Sort left half
            mergesort(array, helper, middle+1, high); // Sort right half
            merge(array, helper, low, middle, high); // Merge them
        }
    }

    public static void merge(int[] array, int[] helper, int low, int middle, int high) {
        /* Copy both halves into a helper array */
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        /* Iterate through helper array. Compare the left and right
         * half, copying back the smaller element from the two halves
         * into the original array. */
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else { // If right element is smaller than left element
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        /* Copy the rest of the left side of the array into the
         * target array */
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }

    public static int binarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] < x) {
                low = mid + 1;
            } else if (a[mid] > x) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int intersection(int[] a, int[] b) {
        // time complexity of merge sort O(n log n)
        mergesort(b);
        int intersect = 0;

        for (int x : a) {
            // time complexity of binary search O(log n)
            if (binarySearch(b, x) >= 0) {
                intersect++;
            }
        }

        return intersect;
    }

    public static void main(String[] args) {
        // First we sort array b which takes O(b log b)
        // then for each element in a, we do a binary search in O(log b)
        // this means the second part takes O(a log b) time
        // therefore the runtime is O(b log b + a log b)
        int[] a = {1, 3, 5, 7};
        int[] b = {1, 9, 2, 7};
        int x = intersection(a, b);
        System.out.println(x);
    }
}
