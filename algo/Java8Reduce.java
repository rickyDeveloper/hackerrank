package algo;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by vikasnaiyar on 23/09/18.
 */
public class Java8Reduce {

    public static void main(String[] args) {

        ConcurrentHashMap<String, Integer> reducedMap = new ConcurrentHashMap<>();

        reducedMap.put("One", 5);
        reducedMap.put("Two", 2);
        reducedMap.put("Three", 3);
        reducedMap.put("Four", 4);

        System.out.println("reduce example => "
                +reducedMap.reduce(2, (k, v) -> v.byteValue(), (total, elem) -> elem ));


    }
}
