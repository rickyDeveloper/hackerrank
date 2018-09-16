package algo;

import java.util.Arrays;

/**
 * Created by vikasnaiyar on 16/09/18.
 */
public class HackerlandRadioTransmitters {

    public static void main(String[] args) {

        //int[] input = {1, 2, 3, 4, 5};

        int[] input = {9, 5, 4, 2, 6, 15, 12};
        //2 4 5 6 9 12 15

        System.out.println(hackerlandRadioTransmitters1(input, 2));
    }

    static int hackerlandRadioTransmitters1(int[] x, int k) {

        if(x.length == 0) {
            return 0;
        }

        if(x.length == 1) {
            return 1;
        }


        Arrays.sort(x);

        int count = 0;
        int i=0, n=x.length;

        while (i < n) {

            int rangeThatCanBeCovered = x[i] + k;

            while (i < n && x[i] <= rangeThatCanBeCovered) {
                ++i;
            }

            rangeThatCanBeCovered = x[i-1] + k;

            while (i < n && x[i] <= rangeThatCanBeCovered) {
                ++i;
            }

            ++count;
        }

        return count;
    }

    static int hackerlandRadioTransmitters(int[] x, int k) {

        if(x.length == 0) {
            return 0;
        }

        if(x.length == 1) {
            return 1;
        }


        int antennaPos = -1;
        int leftMostHouseNeedingAntenna = 0;
        int count = 0;

        for (int i=1; i < x.length;i++) {

            if(antennaPos == -1) {
                if (x[i] - x[leftMostHouseNeedingAntenna] == k) {
                    antennaPos = i;
                    ++count;
                } else if (x[i] - x[leftMostHouseNeedingAntenna] > k) {
                    if(x[i] - x[i-1] > k) {
                        leftMostHouseNeedingAntenna = i;
                        antennaPos = -1;
                    } else if(x[i] - x[i-1] == k) {
                        leftMostHouseNeedingAntenna = i+1;
                        antennaPos = -1;
                    } else {
                        antennaPos = i-1;
                    }
                    ++count;
                } else {
                    if(i+1 >= x.length) {
                        ++count;
                    }
                }
            } else {  //antena available
                if(x[i] - x[antennaPos] > k) {
                    leftMostHouseNeedingAntenna = i;
                    antennaPos = -1;
                }
            }

        }

        if(antennaPos == -1) {
            ++count;
        }

        return count;

    }
}
