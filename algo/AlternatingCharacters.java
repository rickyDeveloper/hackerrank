package algo;

/**
 * Created by vikasnaiyar on 18/09/18.
 */
public class AlternatingCharacters {

    public static void main(String[] args) {
        String s = "AAABBB";

        System.out.println(countDeletions(s));

    }

    public static int countDeletions(String s) {
        int count = 0, n = s.length();

        char nextChar =  (s.charAt(0) == 'A' ? 'B' : 'A');

        for (int i=1; i < n ; i++) {

            if(nextChar == s.charAt(i)) {
                nextChar =  (nextChar == 'A' ? 'B' : 'A');
            } else {
                ++count;
            }
        }

        return count;
    }
}
