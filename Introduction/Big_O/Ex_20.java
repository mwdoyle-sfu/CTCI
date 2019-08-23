package Big_O;

public class Ex_20 {
// Prints out powers of 2 from 1 to n.
// The runtime is the number of times we can divide n by 2 until we get the base case (1).
// The number of times you can half n until you get to 1 is O(log n)
// There are log n powers between 1 and n
// Run time: O(log n)
    private static int powersOf2(int n) {
        if (n == 1) {
            System.out.println(1);
            return 1;
        } else {
            int prev = powersOf2(n / 2);
            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }
    }
//  powersOf2(50)               |
//   -> powersOf2(25)           |
//    -> powersOf2(12)          | Run time = # of times n can be /2
//     -> powersOf2(6)          |          = O(log n)
//      -> powersOf2(3)         |
//       -> powersOf2(1)        |
//      -> print & return 1
//      print & return 2
//     print & return 4
//    print & return 8
//   print & return 16
//print & return 32

// As N goes from P to P+1
// The number of calls to powersOf2 increases by 1 each time n doubles in size
// 2^x = n and x = log n
// Run time: O(log n)
    public static void main(String[] args) {
        powersOf2(50);
    }
}
