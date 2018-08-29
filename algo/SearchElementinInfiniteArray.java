package algo;

import java.util.Map;

/**
 * Created by vikasnaiyar on 29/08/18.
 */
public class SearchElementinInfiniteArray {

    private  static int[] input = {0,1,2,3,4,5,6,7,8,9};


    public static void main(String[] args) {

        System.out.println(findElementInInfiniteArray( 0,1, 9));

    }

    public static int getElementAtIndex(int index) {
        if(index >= input.length) {
            return  -1;
        }

        return index;
    }


    public static int findElementInInfiniteArray(int low, int high, int searchNumber) {

          int lowNumber = getElementAtIndex(low);

          int highNumber = getElementAtIndex(high);

          while (highNumber == -1 && high/2 >= low) {
              highNumber = getElementAtIndex(high/2);
              high = high/2;
          }

          if(highNumber == -1) {
              return -1;
          }

          if(searchNumber >= low && searchNumber <= highNumber) {
              return binarySearch(input,low,high,searchNumber);
          } else {
              return findElementInInfiniteArray(high+1, 2*high, searchNumber);
          }
    }

    public static int binarySearch(int[] input, int low, int high, int searchNumber) {

        if(low > high) {
            return  -1;
        }

        int mid = (low + high)/2;

        if(input[mid] == searchNumber) {
            return mid;
        }

        if(low < mid && input[mid] > searchNumber && input[low] <= searchNumber ) {
            return binarySearch(input, low, mid-1, searchNumber);
        }

        if(high > mid && input[mid] < searchNumber && input[high] >= searchNumber) {
            return binarySearch(input,mid+1, high,searchNumber);
        }

        return  -1;
    }

}
