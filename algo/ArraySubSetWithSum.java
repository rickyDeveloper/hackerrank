package algo;

/**
 * Created by vikasnaiyar on 27/08/18.
 *
 */
public class ArraySubSetWithSum {

    /**
     *
     Input : arr[] = {2, 3, 5, 6, 8, 10}
     sum = 10
     Output : 5 2 3
     2 8
     10

     Input : arr[] = {1, 2, 3, 4, 5}
     sum = 10
     Output : 4 3 2 1
     5 3 2
     5 4 1
     * @param args
     */
    public static void main(String[] args) {

        int input[] = {2, 3, 5, 6, 8, 10};
        int sum = 10;

    }


    public static void printAllSubSets(int input[], int sum) {

        int n = input.length;

        boolean[][] result = new boolean[input.length][sum+1];

        for(int i=0;i<=sum; i++) {
            result[0][i] = true;
        }



    }




}
