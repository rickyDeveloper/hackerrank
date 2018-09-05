package algo;

/**
 * Created by vikasnaiyar on 05/09/18.
 */
public class PrintAnagrams {

    public static void main(String[] args) {
        String input = "abcd";
        printAllPermutation(input,0,input.length()-1);
    }

    public static void printAllPermutation(String str, int leftIndex, int rightIndex) {

        if(leftIndex == rightIndex) {
            System.out.println(str);
        } else {
            for (int i=leftIndex; i<=rightIndex; i++) {
                str = swap(str,leftIndex,i);
                printAllPermutation(str,leftIndex+1,rightIndex);
                str = swap(str,leftIndex,i);
            }
        }
    }

    public static String  swap(String s, int l, int r) {
        char[] chs = s.toCharArray();
        char tmp = chs[l];
        chs[l] = chs[r];
        chs[r] = tmp;
        return new String(chs);
    }

}
