import java.util.Arrays;

/**
 * Created by vikasnaiyar on 22/08/18.
 */
public class KMP {


    public static void main (String[] args) throws java.lang.Exception
    {
        int[] arr = {1, 2, 4, 6, 5, 3, -1};
        Arrays.sort(arr);
        int targetSum = 6;
        String prefixArray = "";
        printAllSubArrays( arr,0,6,prefixArray);
    }

    public static void printAllSubArrays(int[] input, int startIndex, int targetSum, String prefixArray) {

        //boundary
        if(targetSum == 0) {
            System.out.println(prefixArray);
            return;
        }

        if(startIndex >= input.length) {
            return;
        }

        //Improve the complexity --  Include or not.
        // for(int i=startIndex; i<input.length;i++) {
        if(input[startIndex] <= targetSum) {
            printAllSubArrays(input, startIndex+1, targetSum-input[startIndex], prefixArray + input[startIndex] +  ",");
        }

        printAllSubArrays(input, startIndex+1, targetSum, prefixArray);
        //}

    }
}
