package dp;

import java.util.Arrays;

/**
 * Created by vikasnaiyar on 25/09/18.
 */
public class GoldMine {


    /**
     * Args o
     * @param args
     */
    public static void main(String[] args) {

        int gold[][]= { {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2} };

        int m = 4, n = 4;

        System.out.print(getMaxGold(gold, m, n));


    }

    /**
     * Get Max Gold
     * @param gold
     * @param m
     * @param n
     * @return
     */
    public static int getMaxGold(int[][] gold, int m, int n) {

        int[][] maxGold = new int[m][n];

        for (int[] row: maxGold) {
            Arrays.fill(row, 0);
        }


        for (int col=n-1; col>=0; col--) {

            for (int row=0; row<m; row++) {

                int right = (col == n-1) ? 0 : maxGold[row][col+1];

                int topRight = (row == 0 || col == n-1) ? 0 : maxGold[row-1][col+1];

                int bottomRight = (row == m-1 || col == n-1) ? 0 : maxGold[row+1][col+1];

                maxGold[row][col] = gold[row][col] + Math.max(Math.max(right,topRight), bottomRight);
            }

        }


        int maxGoldValue = maxGold[0][0];

        for (int j=1; j<m ; j++) {
            maxGoldValue = Math.max(maxGoldValue, maxGold[j][0]);
        }

        return  maxGoldValue;
    }



}
