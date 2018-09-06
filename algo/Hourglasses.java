package algo;

/**
 * Created by vikasnaiyar on 06/09/18.
 */
public class Hourglasses {


    public static void main(String[] args) {

        int[][] input = {
                {-9 , -9, -9,  1, 1, 1},
                {0, -9,  0,  4, 3, 2},
                {-9, -9, -9,  1, 2, 3},
                {0,  0,  8,  6, 6, 0},
                {0,  0,  0, -2, 0, 0},
                {0,  0,  1,  2, 4, 0}
        };


        int[][] memoization = new int[6][6];

        for (int i = 0; i<input.length;i++) {
            for (int j = 0; j < input.length; j++) {
                if(j == 0) {
                    memoization[i][j] = input[i][j];
                } else {
                    memoization[i][j] = input[i][j] + memoization[i][j-1];
                }
            }
        }

        int maxHour = Integer.MIN_VALUE;

        for (int i=0; i< 4; i++) {
            for (int j=0; j<4; j++) {
                int top = 0, middle=0, bottom=0;
                if(j == 0) {
                    top = memoization[i][2];
                    bottom = memoization[i+2][2];
                } else {
                    top = memoization[i][j+2] - memoization[i][j-1];
                    bottom = memoization[i+2][j+2] - memoization[i+2][j-1];
                }
                middle = memoization[i+1][j+1] -  memoization[i+1][j];
                int sum = top + middle + bottom;
                if(sum > maxHour) {
                    maxHour = sum;
                }
            }
        }

        System.out.print(maxHour);
    }

}
