package Big_O;

public class Ex_14 {
// Run time: O(sqrt(n))
    private static boolean isPrime(int n) {
        // This loop stops when x equals the square root of n
        for (int x = 2; x * x <= n; x++) {
            // Constant time O(1)
            if (n % x == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int x : array) {
            boolean isPrimeNumber = isPrime(x);
            if (isPrimeNumber) {
                System.out.println(x + ": prime");
            } else {
                System.out.println(x + ": not prime");
            }
        }
    }
}
