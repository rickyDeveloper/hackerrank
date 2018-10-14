package dp;

/**
 * Created by vikasnaiyar on 01/09/18.
 */
public class KnapSackProblem {

    public static void main(String[] args) {

        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;

        int[][] result = new int[wt.length+1][W+1];

        for (int i=0; i<=wt.length; i++) {
            for (int j=0; j<=W; j++) {

                if(i == 0 || j == 0) {
                    result[i][j] = 0;
                } else {

                    result[i][j] = result[i-1][j];

                    if(wt[i-1] <= j) {
                        result[i][j] = Math.max(result[i][j] , val[i-1] + result[i-1][j-wt[i-1]]);
                    }
                }
            }
        }

        System.out.print("Max value " + result[val.length][W]);

    }


}