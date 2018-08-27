package algo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by vikasnaiyar on 06/08/18.
 */
public class ArrayRotation {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        int cases = sn.nextInt();
        while (cases > 0) {
            int n = sn.nextInt();
            ArrayList<Integer> al = new ArrayList<>();

            for (int i = 0; i < n; i++)
                al.add(sn.nextInt());

            System.out.println(rotateAndDelete(al,1));
            --cases;
        }

    }

    public static int rotateAndDelete(ArrayList<Integer> arrayList, int deleteCount) {

        if(arrayList == null || arrayList.size() == 0) {
            return -1;
        }

        if(arrayList.size() == 1) {
            return arrayList.get(0);
        }

        int temp = arrayList.get(arrayList.size()-1);
        arrayList.remove(arrayList.size()-1);
        arrayList.add(0,temp);


        if(arrayList.size() < deleteCount) {
            arrayList.remove(0);
        } else {
            arrayList.remove(arrayList.size()-deleteCount);
        }

        return rotateAndDelete(arrayList,++deleteCount);
    }


}
