package dp;

/**
 * Created by vikasnaiyar on 01/09/18.
 */
public class EditDistance {


    public static void main(String[] args) {

        // String str1 = "geek", str2 = "gesek";
        String str1 = "sunday";
        String str2 = "saturday";

        System.out.println(findMinOperation(str1, str2, 0, 0));

        System.out.println(findMinOperationDP(str1, str2));

    }

    /**
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int  findMinOperationDP(String str1, String str2) {

        int[][] result = new int[str1.length()+1][str2.length()+1];

        for (int i=0; i<=str1.length(); i++) {
            for (int j=0; j<=str2.length(); j++) {

                if(i==0) {
                    result[i][j] = j;
                } else

                if(j ==0 ) {
                    result[i][j] =i;
                } else

                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    result[i][j] = result[i-1][j-1];
                } else {
                    result[i][j] = 1 + Math.min( Math.min(result[i][j-1], result[i-1][j]), result[i-1][j-1]);
                }
            }
        }

        return result[str1.length()][str2.length()];
    }


    /**
     * findMinOperation
     * @param str1
     * @param str2
     * @param l1
     * @param l2
     * @return
     */
    public static int findMinOperation(String str1, String str2, int l1, int l2) {

        if(l1 == str1.length()) {
            return 0;
        }

        if(l2 == str2.length()) {
            return 0;
        }



        if(str1.charAt(l1) == str2.charAt(l2)) {
            return findMinOperation(str1,str2,l1+1, l2+1);
        } else {
            return  1 + Math.min(
                            Math.min(findMinOperation(str1,str2,l1, l2+1), //insert
                            findMinOperation(str1,str2,l1+1, l2)), //delete
                            findMinOperation(str1,str2,l1+1, l2+1) //replace
                    );
        }
    }

}
