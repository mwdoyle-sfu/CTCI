package Big_O;

// Just because there are O(n) calls
// doesnt mean it takes O(n) space
public class Ex_02 {
    public static int pairSumSequence(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += pairSum(i, i + 1);
        }
        return sum;
    }
//  pairSum(0, 0 + 1) = 1
//  pairSum(1, 1 + 1) = 3
//  sum = 1 + 3 = 4

// O(n) calls to pairSum but they dont happen simultaneously
// O(1) space is achieved
    public static int pairSum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int s = pairSumSequence(2);
        System.out.println(s);
    }


}
