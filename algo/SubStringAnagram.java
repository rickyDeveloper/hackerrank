package algo;

/**
 * Created by vikasnaiyar on 01/09/18.
 */
public class SubStringAnagram {

    public static void main(String[] args) {
        System.out.println(anagram("xyyx"));

        System.out.println(minDeletions("cde","abc"));
    }

    // Complete the anagram function below.
    static int anagram(String s) {

        if(s.length() % 2 == 1) {
            return -1;
        }

        int[] result = new int[26];


        int mid = s.length()/2;

        for(int i=0; i<mid; i++) {
            int index = ((int) s.charAt(i)) - ((int)'a');
            result[index] = result[index] + 1;
        }

        for(int i=mid; i<s.length(); i++) {
            int index = ((int) s.charAt(i)) - ((int)'a');
            result[index] = result[index] - 1;
        }

        int sum = 0;
        for(int i=0; i<26; i++) {
            sum = sum + Math.abs(result[i]);
        }

        return sum/2;
    }

    // Complete the deletions function below.
    static int minDeletions(String s1, String s2) {

        int[] result = new int[26];

        for(int i=0; i<s1.length(); i++) {
            int index = ((int) s1.charAt(i)) - ((int)'a');
            result[index] = result[index] + 1;
        }

        for(int i=0; i<s2.length(); i++) {
            int index = ((int) s2.charAt(i)) - ((int)'a');
            result[index] = result[index] - 1;
        }

        int sum = 0;
        for(int i=0; i<26; i++) {
            sum = sum + Math.abs(result[i]);
        }

        return sum;
    }
}
