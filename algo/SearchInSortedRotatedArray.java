package algo;

/**
 * Created by vikasnaiyar on 29/08/18.
 */
public class SearchInSortedRotatedArray {

    public static void main(String[] args) {

        int[] input = {4,5, 1,2,3};

        int searchNumber = 4;

        int pivotIndex = findPivot(input, 0, input.length-1);

        System.out.println("PivotIndex --> " + pivotIndex);

        if(pivotIndex == -1) {
            System.out.println("Array is not rotated hence finding number in full array");
            System.out.println("Search index --> " + binarySearch(input,0,input.length,searchNumber));
        } else {
            if(searchNumber >= input[0] && searchNumber <= input[pivotIndex])  {
                System.out.println("Search index --> " + binarySearch(input, 0, pivotIndex, searchNumber));
            } else if (searchNumber >= input[pivotIndex+1] && searchNumber <= input[input.length-1]) {
                System.out.println("Search index --> " + binarySearch(input,  pivotIndex+1, input.length-1, searchNumber));
            } else {
                System.out.println("Number not found in input array");
            }
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

    public static int findPivot(int[] input, int low, int high) {

        if(low > high) {
            return  -1;
        }

        if(low == high) {
            return low;
        }


        int mid = (low + high ) / 2;

        if(mid < high && input[mid] > input[mid+1]) {
            return  mid;
        }


        if(low < mid && input[mid] < input[mid-1]) {
            return mid -1;
        }


        if(input[low] >= input[mid]) {
            return findPivot(input,low, mid-1);
        }

        return findPivot(input, mid+1, high);
    }
}
