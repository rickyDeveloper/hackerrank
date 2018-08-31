package dp;

/**
 * Created by vikasnaiyar on 31/08/18.
 */
public class LongestIncreasingSubSequence {


    public static void main(String[] args) {
        int[] input =  {10, 22, 9, 33, 21, 50, 41, 60, 80};

        int[] result = new int[input.length];

        for (int i=0; i <input.length; i++) {
            result[i] = 1;
        }

        for (int i=1; i < input.length; i++) {
            for (int j=0; j < i; j++) {
                if(input[j] < input[i] && result[i] < result[j] + 1) {
                    result[i] = result[j] + 1;
                 }
            }
        }

        int maxLength = 0;

        for (int i=0; i < input.length; i++) {
            if(maxLength < result[i]) {
                maxLength = result[i];
            }
        }

        System.out.println("Max length is --> " + maxLength);

    }


}
