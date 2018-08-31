package dp;

/**
 * Created by vikasnaiyar on 31/08/18.
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String s1 = "ABCDGH" ;
        String s2 = "AEDFHR";

        int[][] result = new int[s1.length()][s2.length()];

        for (int i=0; i < s1.length(); i++) {
            for (int j=0; j < s2.length(); j++) {
                result[i][j] = -1;
            }
        }

        int count = longestSubSeqCount(s1, s2, result, s1.length() -1, s2.length() -1);

        System.out.println(count);

        count = longestSubSeqCountTabular(s1, s2);
        System.out.println(count);

    }

    /**
     * Memoization approach
     * @param s1
     * @param s2
     * @param result
     * @return
     */
    private static int longestSubSeqCount(String s1, String s2, int[][] result, int i, int j) {

        if(i < 0 || j <0) {
            return 0;
        }

        if(result[i][j] == -1) {
            if(s1.charAt(i) == s2.charAt(j)) {
                result[i][j] = 1 + longestSubSeqCount(s1,s2,result,i-1, j-1);
            } else {
                result[i][j] = Math.max(longestSubSeqCount(s1,s2,result, i-1, j), longestSubSeqCount(s1,s2,result,i,j-1));
            }
        }

        return result[i][j];
    }

    private static int longestSubSeqCountTabular(String s1, String s2) {

        int[][] result = new int[s1.length()+1][s2.length()+1];

        for (int i=0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if(i == 0 || j ==0) {
                    result[i][j] = 0;
                } else if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    result[i][j] = 1 + result[i-1][j-1];
                } else {
                    result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
                }
            }
        }

        return result[s1.length()][s2.length()];
    }

}
