package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by vikasnaiyar on 02/10/18.
 */
public class Abbreviation {


    /**
     *
     * @param args
     */
    public static void main(String[] args) {



        //System.out.println(result[m][n]);

    }


    /*
    /*

        String a = "ABDE";
        String b = "ABDE";

    String a = "AbcDE";
    String b = "ADE";



        Map<Integer, Integer> countMap = new HashMap<>();

        b.chars().map(c -> (char)c).forEach(ch -> countMap.put(ch, countMap.getOrDefault(ch,0) + 1));

        boolean isNotPossible = a.chars().map(c -> (char)c).anyMatch(ch ->  countMap.compute(ch, (key,value) -> value == null ? -1 : --value ) < 0 );

        System.out.println(isNotPossible);

    int m = a.length();
    int n = b.length();

    boolean[][] result = new boolean[m+1][n+1];

    // a is empty
    for(int i= 0; i <= n; i++ ) {
        if(i ==0) {
            result[0][i] = true;
        } else {
            result[0][i] = false;
        }
    }


    int upperCaseCount = 0;

    // b is empty
    for(int i= 0; i <= n; i++ ) {
        if(i == 0) {
            result[i][0] = true;
        } else {
            if((a.charAt(i-1) >= 'A' && a.charAt(i-1) <= 'Z' ) || upperCaseCount == 1) {
                upperCaseCount = 1;
                result[i][0] = false;
            } else {
                result[i][0] = true;
            }
        }
    }

    for (int i=1; i <=m ;i++) {
        for (int j=1; j <= n; j++) {

            if(a.charAt(i-1) == b.charAt(j-1) ) { //matching character
                result[i][j] = result[i-1][j-1];
            } else if(Character.toUpperCase(a.charAt(i-1)) == b.charAt(j-1)) { // upper case matching
                result[i][j] = result[i-1][j-1] || result[i-1][j];
            } else if(a.charAt(i-1) >= 'A' && a.charAt(i-1) <= 'Z'){
                result[i][j] = false;
            } else {
                result[i][j] = result[i-1][j];
            }
        }
    }


    */
}
