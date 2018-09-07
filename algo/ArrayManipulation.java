package algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikasnaiyar on 07/09/18.
 */
public class ArrayManipulation {

    public static void main(String[] args) {

        int[] input = {0,0,0, 0, 0,0,0,0,0, 0,0};

        int[][] queries = {
            {
                    1, 2, 100
            },
            {
                    2, 5, 100
            },
            {
                    3, 4, 100
            }
        };


        for (int[] query: queries) {
            int startIndex = query[0] - 1;
            int endIndex = query[1];
            int numberToBeAdded = query[2];
            input[startIndex] += numberToBeAdded;
            input[endIndex] -= numberToBeAdded;
        }

        long max = Long.MIN_VALUE, maxTillNow = 0;

        for(int i=0; i<11; i++) {
            maxTillNow += input[i];
            max = Math.max(max, maxTillNow);
        }


        /* int[][] queries = {
            {
                1, 5, 3
            },
            {
                4, 8, 7
            },
            {
                6, 9, 1
            }
        };*/



        System.out.println("Max input --> " + max);
        /*
        long max = Long.MIN_VALUE;
        int k = queries.length;
        List<Range> ranges = new ArrayList<>();
        for(int i=0; i < k; i++) {
                ranges.add(new Range(queries[i][0], queries[i][1], queries[i][0]));
                for(int j=0; j < k; j++) {
                    if(i != j) {
                        if(!(queries[i][1] < queries[j][0] || queries[i][0] > queries[j][1])) {

                        }
                    }
                }


            }

        System.out.println("Max input --> " + max);*/

    }



    static class Range {
        int start = 0;
        int end = 0;
        long sum = 0;

        Range(int start, int end, long sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }

        /*for (int[] query:
             queries) {

            int startIndex = query[0] -1;
            int endIndex = query[1] - 1;
            int numberToBeAdded = query[2];


            for(int i=startIndex; i<=endIndex; i++) {
                input[i] += numberToBeAdded;
                if(max < input[i]) {
                    max = input[i];
                }
            }
        }*/
   }

