package algo;

/**
 * Created by vikasnaiyar on 12/10/18.
 */
public class MinPartitionFibonacci {

    public static void main(String[] args) {

        String s = "AAB";

        System.out.println(minCut(s));
        System.out.println(minCut(s));

    }


    public static int minCut(String str) {

        int[][] matrix =  getPalindromMatrix(str, str.length());

        int[] cutCountArray = new int[str.length()];


        for (int i=0; i<str.length(); i++) {

            if(matrix[0][i] == 1) {
                cutCountArray[i] = 0;
            } else {
                cutCountArray[i] = Integer.MAX_VALUE;

                for (int j=0; j<i; j++) {
                    if(matrix[j+1][i] == 1 && 1 + cutCountArray[j] < cutCountArray[i]) {
                        cutCountArray[i] = 1 + cutCountArray[j];
                    }
                }

            }
        }

        return cutCountArray[str.length()-1];

    }

    public static int[][] getPalindromMatrix(String str, int n) {

        int[][] matrix = new int[n][n];

        for (int i=0; i<n; i++) {
            matrix[i][i]= 1;
        }


        for (int i=2; i<= n; i++) {

            for (int j=0; j< n-j+1; j++ ) {

                int end = i + j - 1;
                matrix[i][i] = 0;

                if(str.charAt(i) == str.charAt(end)) { // last characters are matching
                    if (i == 2 || matrix[i + 1][j - 1] == 1) { // internal length matching
                        matrix[i][i] = 1;
                    }
                }
            }
        }

        return matrix;
    }


    public static boolean isPalindrome(String str, int startIndex, int endIndex) {

        boolean isPalindrome = false;




        return isPalindrome;
    }


}
