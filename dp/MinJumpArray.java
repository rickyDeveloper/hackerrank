package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vikasnaiyar on 13/10/18.
 */
public class MinJumpArray {

    public static void main(String[] args) {

        List<Integer> arrayList = Arrays.asList(15, 23, 13, 20, 16, 2, 4, 45, 24, 28, 0, 37, 23, 24, 27, 0, 31, 0, 0, 0, 2, 28, 0, 20, 44, 43, 22, 27, 45, 11, 31, 21, 0, 8, 0, 33, 17, 24, 47, 0, 43, 21, 22, 23, 23, 11, 0, 8, 23, 5, 27, 10, 40, 37, 0, 13, 0, 14, 47, 3, 25, 16, 0, 6, 5, 0, 45, 23, 2, 34, 20, 43, 30, 24, 48, 0, 4, 28, 19, 42, 0, 41, 13, 25, 39, 1, 43, 13, 33, 27, 29, 47, 2, 44, 5, 33, 42, 20, 34, 1, 30, 28, 37, 0, 0, 0, 28, 39, 10, 49, 0, 11, 0, 24, 0, 21, 36, 29, 26, 21, 0, 0, 27, 5, 41, 22, 34, 0, 0, 7, 38, 49, 3, 39, 0, 44, 25, 22, 21, 0, 2, 3, 8, 0, 0, 41, 49, 28, 21, 0, 9, 12, 12, 15, 20, 0, 35, 31, 10, 0, 0, 10, 12, 48, 0, 8, 16, 1, 9, 0, 32, 49, 39, 39, 28, 0, 30, 4, 0, 6, 27, 29, 12, 25, 17, 0, 0, 19, 21, 31, 0, 0, 46, 0, 11, 0, 9, 17, 0, 14, 9, 41, 31, 40, 0, 0, 23, 41, 50, 17, 0, 0, 32, 4, 38, 5, 27, 19, 45, 9, 26, 37, 35, 24, 10, 5, 13, 4, 40, 12, 25, 10, 2, 12, 13, 0, 10, 14, 1, 49, 5, 1, 49, 46, 0, 14, 45, 0, 1, 46, 46, 27, 0, 9, 23, 19, 0, 0, 0, 0, 46, 18, 41, 0, 12, 22, 28, 49, 15, 0, 49, 35, 34, 0, 43, 0, 0, 0, 0, 6, 30, 29, 0, 25, 18, 0, 1, 2, 14, 0, 42, 27, 26, 27, 2, 50, 21, 48, 10, 27, 24, 0, 34, 0, 0 );

        int minCount = -1;

        if(arrayList.size() == 1 && arrayList.get(0) == 0) {
            minCount = 0;
        } else if(arrayList.get(0) > 0) {

            int prevMaxReachable = arrayList.get(0);
            int currentMaxReachable = arrayList.get(0);
            minCount=1;

            if(prevMaxReachable < arrayList.size()-1) {
                for (int i = 1; i < arrayList.size(); i++) {

                    // boundary condition
                    if (arrayList.get(i) == 0 && currentMaxReachable <= i) {
                        minCount = -1;
                        break;
                    }


                    // get current max
                    if (i + arrayList.get(i) > currentMaxReachable) {
                        currentMaxReachable = i + arrayList.get(i);
                    }


                    // has overflown the size
                    if(currentMaxReachable >= arrayList.size()-1 && i <= prevMaxReachable) {
                        ++minCount;
                        break;
                    }

                    // If prevMax reached but not reached end of array
                    if(i == prevMaxReachable) {
                        prevMaxReachable = currentMaxReachable;
                        ++minCount;
                    }

                }
            }


        }

        System.out.println(minCount);
    }

}
