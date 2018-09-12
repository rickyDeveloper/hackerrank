package algo;

import java.util.Arrays;

/**
 *
 * https://www.hackerrank.com/challenges/mark-and-toys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 *
 * Created by vikasnaiyar on 12/09/18.
 */
public class MaxToysSortingProblem {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int len = prices.length;
        int tempSum = 0;
        int i =0;
        for(; i<len; i++) {
            tempSum += prices[i];
            if(tempSum > k) {
                break;
            }
        }

        return i;
    }

}
