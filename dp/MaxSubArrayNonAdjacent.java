package dp;

import java.util.Arrays;

/**
 * Created by vikasnaiyar on 27/09/18.
 */
public class MaxSubArrayNonAdjacent {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //int[] arr = {-2, 1, 3, -4 , 5};
        int[] arr = {
                2, 1 ,5, 8, 4
        };

        System.out.println(maxSubsetSum1(arr));
    }

    // Complete the maxSubsetSum function below.
    private static int maxSubsetSum1(int[] arr) {

        // this position
        // max till now
        // this position + max(i-2)

        int n = arr.length;

        int max = Math.max(arr[0], arr[1]);

        int maxLeft = arr[0];

        for (int i=2;i<n; i++) {
            int temp = max;

            max = Math.max(Math.max(arr[i], max), maxLeft + arr[i]);

            maxLeft = temp;

        }

        return max;
    }

        // Complete the maxSubsetSum function below.
    private static int maxSubsetSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        int[][] tempMax = new int[n][n];

        for (int[] temp: tempMax) {
            Arrays.fill(temp, Integer.MIN_VALUE);
        }

        int len = 2;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j=j+len) {
                if(i==j) { // fill one length array
                    tempMax[i][j] = arr[i];
                } else {
                    tempMax[i][j] = arr[j] + arr[i];
                }

                if(tempMax[i][j] > max) {
                    max = tempMax[i][j];
                }
            }
        }


        for(int i=0; i<n-3; i++) {
            for(int j=3; j<n-1; j++) {
                int k = j;
                while (k < n) {
                    tempMax[i][k] = Math.max(tempMax[i][k], arr[i] + arr[i+j]);

                    if(tempMax[i][k] > max) {
                        max = tempMax[i][k];
                    }

                    k += j;
                }
            }
        }



        return max;
    }
}
