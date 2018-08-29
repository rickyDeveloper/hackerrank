package algo;

/**
 * Created by vikasnaiyar on 29/08/18.
 */
public class SparseSearchInArray {

    public static void main(String[] args) {

        String[] input = {"at","", "","ball","", "", "car","","","dad"};

        String searchText = "car";

        int index = searchString(input,searchText,0, input.length-1);

        if(index == -1) {
            System.out.println("Search text not found in array ");
        } else {
            System.out.println("Found text at index " + index);
        }

    }

    private static int searchString(String[] input, String searchText, int low, int high) {

        if(low > high) {
            return -1;
        }

        int mid = (low + high)/2;

        if("".equals(input[mid])) {
            System.out.println("Found empty string at index --> " + mid);
            mid = findNextNearestString(input, low, high, mid-1, mid+1);
        }

        if(mid == -1) {
            return -1;
        }

        System.out.println("Found non-empty string at index --> " + mid);


        int compareInt = input[mid].compareTo(searchText);

        if(compareInt == 0) {
            return mid;
        } else if (low < mid && compareInt > 1) {
            return searchString(input,searchText, low, mid-1);
        } else if( high > mid && compareInt < 0) {
            return searchString(input,searchText,  mid+1, high);
        }

        return -1;
    }


    private static int findNextNearestString(String[] input, int low, int high, int midLow, int midHigh) {

        int index = -1;

        while(index == -1 && (midLow <= low || midHigh <= high)) {
            if(low <= midLow && !"".equals(input[midLow])) {
                index = midLow;
            } else if(high >= midHigh && !"".equals(input[midHigh])) {
               index = midHigh;
            } else {
                midHigh++;
                midLow++;
            }
        }

        return index;
    }
}
