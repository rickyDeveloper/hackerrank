package algo;

/**
 * Created by vikasnaiyar on 06/09/18.
 */
public class ArrayLeftRotation {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] input = {1, 2, 3, 4 ,5};

        int n = 5;
        int k = 4;


        if(k != n) {

            for (int i=0; i <k; i++) {
                int temp = input[0];
                for (int j = 1; j < n; j++ ) {
                    input[j-1] = input[j];
                }

                input[n-1] = temp;
            }

        }

        for (int i=0; i < n; i++) {
            System.out.print(input[i] + " ");
        }

    }

}
