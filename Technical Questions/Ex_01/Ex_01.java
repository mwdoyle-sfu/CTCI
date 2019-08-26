package Ex_01;
import java.lang.Math;
import java.util.HashMap;

/*
* Print all positive integer solutions to the equation
* a3 + b3 = c3 + d3 where a, b, c, and d are integers
* between 1 and 1000.
*/

public class Ex_01 {

    // Brute force solution runs in O(n^4)
    private static void posIntSolutions1(int n) {
        for (int a = 1; a < n; a++) {
            for (int b = 1; b < n; b++) {
                for (int c = 1; c < n; c++) {
                    for (int d = 1; d < n; d++) {
                        if (Math.pow(a, 3) + Math.pow(b, 3) == Math.pow(c, 3) + Math.pow(d, 3)) {
                            System.out.printf("%d + %d = %d + %d\n",a,b,c,d);
                        }
                    }
                }
            }
        }
    }

    public static void posIntSolutions2(int n) {
        for (int a = 1; a < n; a++) {
            for (int b = 1; b < n; b++) {
                for (int c = 1; c < n; c++) {
                    for (int d = 1; d < n; d++) {
                        if (Math.pow(a, 3) + Math.pow(b, 3) == Math.pow(c, 3) + Math.pow(d, 3)) {
                            System.out.printf("%d + %d = %d + %d\n",a,b,c,d);
                            // It is unnecessary to keep checking d's value
                            // break out of d's loop
                            break;
                        }
                    }
                }
            }
        }
    }

    // There is only one valid d value for each (a,b,c)
    // computing this value reduced runtime to O(n^3)
    public static void posIntSolutions3(int n) {
        for (int a = 1; a < n; a++) {
            for (int b = 1; b < n; b++) {
                for (int c = 1; c < n; c++) {
                    double d = Math.pow(Math.pow(a,3) + Math.pow(b,3) - Math.pow(c,3),1/3);
                    if (Math.pow(a, 3) + Math.pow(b, 3) == Math.pow(c, 3) + (int)d) {
                        System.out.printf("%d + %d = %d + %d\n",a,b,c,(int)d);
                        break;
                    }
                }
            }
        }
    }

    // the algorithm operates by iterating through all (a,b) pairs
    // then searching all (c,d) pairs to find if there are any matches
    // that match the (a,b) pair. Why do we keep computing the (c,d) pairs
    // for each (a,b) pair? We should just create a list of (c,d) pairs once
    // Then, we have a (a,b) pair, find the matches within the (c,d) list.
    // We can quicly locate the matches by inserting each (c,d) pair into a hash
    // table that maps from the sum to the pair ( or rather the list of pairs)
    public static class Pair{
        int a, b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        public String toString() {
            return this.a + " + " + this.b;
        }
    }

    public static void posIntSolutions4(int n) {

        HashMap<Integer, Pair> map = new HashMap<Integer, Pair>();

        for (int c = 1; c < n; c++) {
            for (int d = c; d < n; d++) {
                int result = (int) (Math.pow(c, 3) + Math.pow(d, 3));
                if (map.containsKey(result)) {
                    System.out.println(new Pair(c,d).toString() + " = " + map.get(result));
                } else {
                    map.put(result, new Pair(c,d));
                }
            }
        }
    }

    public static void main(String[] args) {
        posIntSolutions4(1000);
    }
}
