package algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by vikasnaiyar on 07/09/18.
 */
public class SherlockAndAnagrams {

    public static void main(String[] args) {

       // String s1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"; //"abba";

        String s1 = "mom";

        int[] primeNumers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

        Map<Long, Integer> countMap = new HashMap<>();
        int len = s1.length();

        for (int i=1; i <= len; i++) { //length
            for (int j=0; j<=len-i; j++) {
                long product = 1;
                for (int k=j; k<j+i; k++) {
                    product *= primeNumers[((int)s1.charAt(k)) - 'a'];
                }
                System.out.println(s1.substring(j, j+i) + " = " + product);
                if(countMap.containsKey(product)) {
                    countMap.put(product, 1 + countMap.get(product));
                } else {
                    countMap.put(product,1);
                }

                for (int m=j+1; m < len - i +1; m++) {
                    System.out.println(s1.substring(m, m+i) + " == " + product);
                }
            }
        }

       /* for (int i=1; i <= len; i++) { //length
            for (int j=0; j<=len-i; j++) { //
                double product = 1;
                for (int k=i; k<=j; k++) {
                    product *= primeNumers[((int)s1.charAt(k)) - 'a'];
                }

                if(countMap.containsKey(product)) {
                    countMap.put(product, 1 + countMap.get(product));
                } else {
                    countMap.put(product,1);
                }
            }
        }

        HashMap<Integer, Integer> factorialMap = new HashMap<>();

        int anagramsCount = countMap.entrySet().stream().filter(e -> e.getValue() > 1).mapToInt(e -> {

            int i; int fact=1;

            if(factorialMap.containsKey(e.getValue())) {
                fact = factorialMap.get(e.getValue());
            } else {
                for(i=e.getValue()-1;i<=e.getValue();i++){
                    fact=fact*i;
                }
                fact= fact/2;
                factorialMap.put(e.getValue(), fact);
            }

            return  fact;
        }).sum();

        System.out.println(anagramsCount);*/
    }

}
