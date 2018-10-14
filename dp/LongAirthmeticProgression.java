package dp;

import java.util.*;

/**
 * Created by vikasnaiyar on 14/10/18.
 */
public class LongAirthmeticProgression {

    public static void main(String[] args) {

        //List<Integer> input = Arrays.asList(3, 6, 9, 12);

        List<Integer> input = Arrays.asList(1, 7, 10, 13, 14, 19);

        List<Map<Integer, Integer>> result  = new ArrayList<>();

        for (int i=0; i<input.size(); i++) {
            result.add(new HashMap<>());
        }

        int max = 1;

        for (int i= 1;i < input.size(); i++) {
            Map<Integer, Integer> currentNode = result.get(i);
            for (int j=0; j<i; j++) {

                int diff = input.get(i) - input.get(j);
                if(diff > 0) {
                    Map<Integer, Integer> node = result.get(j);
                    int nodeCount = node.getOrDefault(diff,1);
                    int count = 1;

                    if(currentNode.containsKey(diff)) {
                        count = currentNode.get(diff);
                    }

                    currentNode.put(diff, nodeCount + count );

                    // updating max count
                    if(nodeCount + count > max) {
                        max = nodeCount + count;
                    }
                }

            }
        }

        System.out.println(max);
    }
}
