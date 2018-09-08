package algo;

import java.util.*;

/**
 * Created by vikasnaiyar on 07/09/18.
 */
public class CountTriplets {

    public static void main(String[] args) {

        int factor = 1;

        //List<Long> input = new ArrayList<>(Arrays.asList(1L,3L,9L,9L,27L,81L));
        //List<Long> input = new ArrayList<>(Arrays.asList( 1L, 5L, 5L, 25L, 125L));

        List<Long> input = new ArrayList<>(Arrays.asList(
        1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L,1L
        ));


        int len = input.size();

        Map<Long,Integer> secondMap = new HashMap<>();

        Map<Long,Integer> thirdMap = new HashMap<>();

        long tripletsCount = 0;

        for (int i=0; i<len; i++) {
            long currentElement = input.get(i);
            if(thirdMap.containsKey(currentElement)) {
                tripletsCount += thirdMap.get(currentElement);
            }

            if(secondMap.containsKey(currentElement)) {
                thirdMap.put(currentElement*factor, thirdMap.getOrDefault(currentElement*factor,0) + secondMap.get(currentElement));
            }

            secondMap.put(currentElement*factor, secondMap.getOrDefault(currentElement*factor, 0) + 1);
        }

        /*
        for (int i=0; i<len; i++) {
            if(numberMap.containsKey(input.get(i))) {
                numberMap.put(input.get(i),  1+ numberMap.get(input.get(i)));
            } else {
                numberMap.put(input.get(i), 1);
            }

            if(factor > 1) {
                long firstNumber = input.get(i)/(factor*factor);
                long secondNumber = input.get(i)/factor;
                if(numberMap.containsKey(firstNumber) && numberMap.containsKey(secondNumber)) {
                    tripletsCount += numberMap.get(firstNumber) * numberMap.get(secondNumber);
                }
            }
        }

        if(factor == 1) {
            tripletsCount = numberMap.entrySet().stream().filter(e -> e.getValue() >=3).mapToLong( e -> {
                return e.getValue() * (e.getValue() -1) * (e.getValue() -2 ) / 6;
            }).sum();
        }*/

        System.out.println(tripletsCount);
    }

}
