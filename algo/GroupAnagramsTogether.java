package algo;

import java.util.*;

/**
 * Created by vikasnaiyar on 28/08/18.
 */
public class GroupAnagramsTogether {

    public static void main(String[] args) {

        String[] input = {"abc", "cbad", "xyz", "dacb", "bca", "yxz"};

        Map<String, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            char[] ch = input[i].toCharArray();
            Arrays.sort(ch);
            String tmp = new String(ch);
            if(!map.containsKey(tmp)) {
                map.put(tmp, new HashSet<>());
            }
            map.get(tmp).add(i);
        }

        map.keySet().stream().forEach(k -> map.get(k).stream().map(i -> input[i]).forEach(System.out::println));
    }

}
