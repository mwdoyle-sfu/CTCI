package Big_O;

// Space complexity:
// Both time and space should be considered
// an array of n takes O(n) space
// an nxn array take O(n^2)

// Stack space in recursive calls also takes space
// Ex 1 takes O(n) space
public class Ex_01 {
    public static int sum(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sum(n-1);
    }
// 4 + sum(4 - 1)   4 + 6 = [10]
// 3 + sum(3 - 1)   3 + 3 = 6
// 2 + sum(2 - 1)   2 + 1 = 3
// 1 + sum(1 - 1)-> 1 + 0 = 1
//           0

// Each call adds a level to the stack.
//  1 sum(4)
//      2 -> sum(3)
//          3 -> sum(2)
//              4 -> sum(1)
//                  5 -> sum(0)

    public static void main(String[] args) {
        int s = sum(4);
        System.out.println(s);
    }
}
