package algo;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by vikasnaiyar on 17/09/18.
 */
public class HackerRank {

    public static void main(String args[] ) throws Exception {


        int[] a = {2,3,10,2,4,8,1};

       /* boolean endOfCommand = false;

        Scanner scanner = new Scanner(System.in);

        while (!endOfCommand) {
            String nextInputCommand = null;

            // This code is just for end of inputs condition.
            try {
                nextInputCommand = scanner.nextLine();
            } catch (Exception ex) {
                endOfCommand = true;
            }

        }*/

        //System.out.println(maxDifference(a));

        int n = 23;
        BigInteger[] fact = new BigInteger[n+1];
        fact[0] = new BigInteger("1");
        fact[1] = new BigInteger("1");

        String str = "" + factorial(n);
        System.out.println(str);

        System.out.println(countZero(str));

    }


    static BigInteger factorial(int n) {
        BigInteger prevFact = new BigInteger("1");
        BigInteger fact = prevFact;
        for (int i=2;i <=n; i++) {
            String j = "" + i;
            fact =  new BigInteger(j).multiply(prevFact);
            prevFact = fact;
        }

        return fact;
    }

    static int countZero(String s) {

        int count = 0, n = s.length();

        for(int i=n-1; i>=0;i--) {
            if('0' == s.charAt(i)) {
                ++count;
            } else {
                break;
            }
        }

        return count;
    }

    // Complete the maxDifference function below.
    static int maxDifference(int[] a) {

        if(a == null || a.length == 1) {
            return -1;
        }

        int maxDiff = Integer.MIN_VALUE;
        boolean foundMin = false;
        int min = 0, n =a.length;

        for (int i=0; i < a.length; i++) {
            if(a[i] > a[min]) {
                foundMin = true;
                if(maxDiff < a[i] - a[min]) {
                    maxDiff = a[i] - a[min];
                }
            }

            if(a[i] < a[min]) {
                min = i;
            }
        }

        if(!foundMin) {
            maxDiff = -1;
        }

        return  maxDiff;
    }
}
