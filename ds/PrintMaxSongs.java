package com.naiyarv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by vikasnaiyar on 23/07/18.
 */
public class PrintMaxSongs {

    public static void main(String[] args) {

       List<Integer> input = Arrays.asList(2, 2, 2, 3, 3, 4, 4, 5);

       // List<Integer> input = Arrays.asList( 2, 4, 3, 5, 5, 2, 4);

        int duration = 20;

       System.out.println(printMaxSongs(input,0, duration, 0));

        // 2 2 3 4 4 5 5
        // 2 2 2 3 3 4 4 5
        Collections.sort(input);

        System.out.println(printMaxSongs1(input, duration));
    }

    public static int printMaxSongs1(List<Integer> input, int duration) {
          int tempDuration = 0;
          int count = 0;
          int index = 0;

          while(tempDuration <= duration && index < input.size()) {
              if(tempDuration + input.get(index) <= duration) {
                  ++count;
                  tempDuration = tempDuration + input.get(index);
              }
              ++index;
          }

          return  count;
    }

    public static int printMaxSongs(List<Integer> input, int index, int duration, int count) {

            if(index >= input.size()) {
                return 0;
            }

            if(duration == 0) {
                return 0;
            }

            if(input.get(index) <= duration) {
                return Math.max(1 + printMaxSongs(input, index+1, duration-input.get(index), count+1),
                        printMaxSongs(input, index+1, duration, count));
            } else {
                return printMaxSongs(input, index+1, duration, count);
            }
    }
}
