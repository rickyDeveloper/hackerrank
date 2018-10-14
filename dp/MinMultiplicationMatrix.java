package dp;

/**
 * Created by vikasnaiyar on 12/10/18.
 */
public class MinMultiplicationMatrix {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] matrix = {1,2,3, 4};

        int[][] result = new int[matrix.length][matrix.length];


        for (int i=0;i<matrix.length; i++) {
            result[i][i] = 0;
        }

        for (int L=2; L < matrix.length; L++) {

            for (int i=1; i<matrix.length-L+1; i++) {

                int j = i + L -1;

                result[i][j] = Integer.MAX_VALUE;

                for (int k=i; k<j; k++) {

                    int tempMin = result[i][k] + result[k+1][j] +  matrix[i-1] * matrix[k] * matrix[j];

                    if(tempMin < result[i][j]) {
                        result[i][j] = tempMin;
                    }

                }
            }
        }

        System.out.println(result[1][matrix.length-1]);
    }

}
