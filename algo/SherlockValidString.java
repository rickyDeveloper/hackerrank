package algo;

import java.util.*;

/**
 * Created by vikasnaiyar on 18/09/18.
 */
public class SherlockValidString {

    public static void main(String[] args) {
        String s = "abcdefghhgfedecba";

        System.out.println(isValidString(s));
    }

    private static String isValidString(String s) {

        int n = s.length();

        Map<Character, Integer> countMap = new HashMap<>(3);

        for ( int i=0; i<n; i++) {
            countMap.put(s.charAt(i), 1 + countMap.getOrDefault(s.charAt(i), 0));
        }

        List<Integer> values = new ArrayList<>(countMap.values());
        countMap = null;
        Collections.sort(values);

        if(values.size() == 1) {
            return "YES";
        }

        if(values.get(0) == values.get(values.size()-1)) {
            return "YES";
        }

        if(values.get(0) == values.get(values.size()-2) && (values.get(values.size()-1) - values.get(0)) == 1) {
            return "YES";
        }


        if(values.get(1) == values.get(values.size()-1) && (values.get(0) - values.get(values.size()-1)) == 1) {
            return "YES";
        }


        if(values.get(1) == values.get(values.size()-1) && values.get(0) == 1) {
            return "YES";
        }

        return "NO";
    }
}
