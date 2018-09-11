package algo;

import java.util.*;

/**
 * Created by vikasnaiyar on 12/09/18.
 */
public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> results = new ArrayList<>();
        Map<Integer, Integer> valueCountMap = new HashMap<>();
        Map<Integer, Set<Integer>> countValueMap = new HashMap<>();

        queries.stream().forEach(q -> {
            int operation = q.get(0);
            int value = q.get(1);
            if(operation == 1) {
                valueCountMap.put(value, 1 + valueCountMap.getOrDefault(value,0));
                int current = valueCountMap.get(value);
                countValueMap.putIfAbsent(current, new HashSet());
                countValueMap.compute(current, (k,v) -> { v.add(value); return v;});
            } else if(operation == 2) {
                int current = valueCountMap.getOrDefault(value,0);
                if(current > 0) {
                    countValueMap.compute(current, (k,v) ->  { v.remove(value);  return v.isEmpty() ? null:v;});

                    valueCountMap.computeIfPresent(value, (k,v) ->
                    {--v; return (v == 0 ? null : v);});

                    if(current > 1) {
                        countValueMap.putIfAbsent(current-1, new HashSet());
                        countValueMap.compute(current-1, (k,v) -> { v.add(value); return v;});
                    }
                }
            } else if(operation == 3) {
                if(countValueMap.containsKey(value)) {
                    results.add(1);
                } else {
                    results.add(0);
                }
            }
        });

        return results;

    }

}
