package Big_O;
/*
* The following code sums the digits in a number. What is its big 0 time?
*/
public class Q_10 {
    // The runtime will be the number of digits in the number
    // a number of d digits can have a value up to 10^d
    // if n = 10^d, then d = log n
    // this means runtime is O(log n)
    private static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            // modulo gives remainder
            sum += n % 10;
            // division gives quotient
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumDigits(123));
    }
}
