package algo;

/**
 * Created by vikasnaiyar on 13/08/18.
 */
public class ParititionArray {

    public  static void main(String[] args) {

        int[] input = {1,2,2};

        int start = 0, end = input.length-1;

        printAllSubArrays(input, start, end, "");

    }

    public static void printAllSubArrays(int[] input, int left, int right, String prefix
                                          ) {

        if(left > right) {
            System.out.println(prefix);
            return;
        }

        String suffix = "";

        for (int i= left; i<=right; i++) {

            if("".equals(suffix)) {
                if("".equals(prefix)) {
                    suffix = "{" + input[i] ;
                } else {
                    suffix = prefix + ", {" + input[i] ;
                }
            } else {
                suffix += "," + input[i] ;
            }

            //for (int j=i+1; j<=right; j++) {
                printAllSubArrays(input,i+1,right, suffix + "}");
            //}
        }
    }

}
