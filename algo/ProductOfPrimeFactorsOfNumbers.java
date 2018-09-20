package algo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by vikasnaiyar on 20/09/18.
 */
public class ProductOfPrimeFactorsOfNumbers {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] numbers = {3,10,12,7};

        Map<Integer, Set<Integer>> factorsMap = new HashMap<>();
        for (int num: numbers) {
            if(!factorsMap.containsKey(num)) {
                Set<Integer> factors = populatePrimeFactors(num, factorsMap);
                factorsMap.put(num, factors);
            }
        }

        Set<Integer> uniqueFactors = factorsMap.values().stream().flatMap(Set::stream).collect(Collectors.toSet());

        uniqueFactors.stream().forEach(System.out::println);

    }

    private static Set<Integer>  populatePrimeFactors(int num,   Map<Integer, Set<Integer>> factorsMap) {

        Set<Integer> factors = new HashSet<>();

            int startNumber = 2;

            while (num > 1) {

                if(factorsMap.containsKey(num)) {
                    factors.addAll(factorsMap.get(num));
                    break;
                }

                int remainder = num % startNumber;

                if(remainder == 0) {

                    num = num / startNumber;

                    factors.add(startNumber);

                    startNumber = 2;

                } else {
                    ++startNumber;
                }
            }

        return  factors;
    }


}
