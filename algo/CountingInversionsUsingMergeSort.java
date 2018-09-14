package algo;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by vikasnaiyar on 12/09/18.
 */
public class CountingInversionsUsingMergeSort {

    public static void main(String[] args) {

        //int[] input = {2, 1, 3, 1, 2};
        //int[] input = {7, 5, 3, 1};
        int[] input = {2 ,1, 3, 1, 2};
        //int[] input = {1, 3, 5, 7};
        int n = input.length;

       int[] temp = new int[n];

        System.out.println("Intersion count is " + getInversionCount(input, temp, 0, n-1));
    }

    private static long getInversionCount(int[] array, int[] temp, int left, int right) {

        long count = 0;

        if(left >= right) {
            return count;
        }

        int mid = left + (right-left)/2;
        count +=  getInversionCount(array, temp, left, mid);
        count +=  getInversionCount(array,  temp, mid+1, right);
        count += merge(array,temp, left,mid,right);

        return count;
    }

    private static long merge(int[] a, int[] temp, int left, int mid, int right){
        long count = 0;
        for(int k = left; k <= right; k++){
            temp[k] = a[k];
        }
        int i = left, j = mid + 1;
        for(int k = left; k <= right; k++){
            if(i > mid) a[k] = temp[j++];
            else if(j > right) a[k] = temp[i++];
            else if(temp[j] < temp[i]){
                a[k] = temp[j++];
                count += (mid - i + 1);
            }
            else a[k] = temp[i++];
        }
        return count;
    }

}
