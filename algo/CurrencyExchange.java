package algo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * Created by vikasnaiyar on 31/07/18.
 */
public class CurrencyExchange {


    /*
           AUSUSD = 0.8
           JPYUSD = 0.9

           adjacency list




     */
    public static void main(String[] args) {

        String node = "caaab";
        String pa ="aa";

     /*   Matcher m = Pattern.compile("aa").matcher(pa);

        while (m.find()) {
            System.out.print("Found result");
        }*/

        int index = node.indexOf(pa);
        System.out.println("Index1 " + index);

        while(index >= 0) {
            index = node.indexOf(pa, index+1);
            System.out.println("Index2 " + index);
        }

        char c = 'c';
        char a = 'a';
        System.out.println((int)c - (int)a);

      /*  double[][] graph = new double[3][3];

        // AUS
        graph[0][0] = 0;
        graph[0][1] = 0.8;
        graph[0][2] = 0;

        // USD
        graph[0][0] = 0;
        graph[0][1] = 0.8;
        graph[0][2] = 0;


        // JPY

        System.out.println(maximizingXor(10,15));*/

    }

    static int maximizingXor(int l, int r) {
        return IntStream.range(l, r+1).map( i -> {
                    IntStream stream1 = IntStream.range(i, r+1);
                    return  stream1.map(j -> {
                        return i^j;
                    }).max().getAsInt();
                }
        ).max().getAsInt();
    }

}
