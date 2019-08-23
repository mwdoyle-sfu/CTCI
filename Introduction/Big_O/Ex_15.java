package Big_O;

public class Ex_15 {
// Computes n!
// Run time: O(N)
// Since it contains one recursive function
    private static int factorial(int n) {
        if (n < 0) {
            return -1;
        }
         else if (n == 0) {
             return 1;
        } else {
             return n * factorial(n -1);
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(4));
    }
}
