package dp;

/**
 * Created by vikasnaiyar on 25/09/18.
 */
public class CountBalancedBinaryTree {


    public static void main(String[] args) {

        int height = 4;

        int[] heightArray = new int[height+1];
        heightArray[0] = 1;
        heightArray[1] = 1;

        int countOfBinTree = 0;

        for (int i=2; i<= height; i++) {
            heightArray[i] = heightArray[i-1] * ( 2 * heightArray[i-2] + heightArray[i-1]);
        }

        System.out.println(heightArray[height]);

    }

}
