package dp;

/**
 * Created by vikasnaiyar on 31/08/18.
 */
public class FibonacciWithDP {

    public  static void main(String[] args) {
        int n =9;
        System.out.println("Fibonacci number at position " + n + " is " + fibonacci(n) );
    }

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
