package dp;

/**
 * Created by vikasnaiyar on 31/08/18.
 */
public class FibonacciWithDP {

    public  static void main(String[] args) {
        int n =9;

        int[] result = new int[n+1];
        fibonacciMemoization(n, result);

        System.out.println("Fibonacci number at position " + n + " is " + fibonacciMemoization(n, result) );

    }

    /**
     * Memoization technique
     * @param n
     * @return
     */
    private static int fibonacciMemoization(int n, int[] result) {

        if(result[n] == 0) {
            if(n <= 1) {
                result[n] = n;
            } else {
                result[n] = fibonacciMemoization(n-1, result) + fibonacciMemoization(n-2, result);
            }

        }

        return  result[n];

    }

        /**
         * Top Down apprach
         * @param n
         * @return
         */
    private static int fibonacci(int n) {

        if(n <= 1) {
            return 1;
        }

        int[] result = new int[n+1];

        result[0] = 0;
        result[1] = 1;


        for (int i=2; i<=n; i++) {
            result[i] = result[i-1] + result[i-2];
        }

        return result[n];
    }

}
