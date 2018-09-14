package algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vikasnaiyar on 14/09/18.
 */
public class LilysHomework {

    public static void main(String[] args) {

        int[] input = {2, 5, 3, 1};

        System.out.println(lilysHomework(input));
        //System.out.println(lilysHomeworkUsingMergeSort(input,new int[4],0,input.length-1));


    }

    static int lilysHomework(int[] input) {

        int swapCount = 0;
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        int[] temp = new int[input.length];
        for (int i=0; i<input.length; i++) {
               valueIndexMap.put(input[i], i);
               temp[i] = input[i];
        }

        Arrays.sort(temp); // sort array

        for (int i=0; i<input.length;i++) {
            if(temp[i] != input[i]) {
                ++swapCount;
            }

            int index = valueIndexMap.get(temp[i]);
            valueIndexMap.put(input[i], index);
            int swapValue = input[i];
            input[i] = temp[i];
            input[index] = swapValue;
        }


        return swapCount;
    }

    static int lilysHomeworkUsingMergeSort(int[] arr, int[] temp, int left, int right) {
        int count =0;

        if(left >= right) {
            return count;
        }

        int mid = left + (right - left )/2;
        count += lilysHomeworkUsingMergeSort(arr, temp,left, mid);
        count += lilysHomeworkUsingMergeSort(arr, temp, mid+1, right);
        count += merge(arr,temp,left,mid, right);

        return count;
    }

    /**
     * Merge out
     * @param arr
     * @param temp
     * @param left
     * @param right
     * @param mid
     * @return
     */
    static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int j=left, k=mid+1;
        for (int i=left; i<= right; i++) {
            if(j > mid) {
                arr[i] = temp[k++];
            } else if(k > right) {
                arr[i] = temp[j++];
            } else if(temp[j] > temp[k]) {
                arr[i] = temp[k++];
                ++count;
            } else {
                arr[i] = temp[j++];
            }

        }

        return count;
    }

}
