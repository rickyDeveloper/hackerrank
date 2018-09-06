package algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikasnaiyar on 06/09/18.
 */
public class NewYearChaos {

    public static void main(String[] args) {
        //int[] line = {2, 1, 5, 3, 4};
        //int[] line = {2, 5, 1, 3, 4};

        int[] line = {1, 2, 5, 3, 7, 8, 6, 4};
        int n = line.length;

        int swapCount = 0;
        boolean isTooChaotic = false;

        List<Integer> reverseLine = new ArrayList<>();
        for (int i=n; i>0; i--) {
            reverseLine.add(i);
        }

        for(int i=0; i < n; i++) {
            int currentSwapCount = line[i] -1 - i ;
                if( currentSwapCount > 2) {
                    isTooChaotic = true;
                    System.out.println("Too chaotic");
                    break;
                } else {
                    if(reverseLine.get(reverseLine.size()-1) == line[i]) {
                         reverseLine.remove(reverseLine.size()-1);
                    } else if(reverseLine.get(reverseLine.size()-2) == line[i]){
                        swapCount += 1;
                        reverseLine.remove(reverseLine.size()-2);
                    } else if(reverseLine.get(reverseLine.size()-3) == line[i]){
                        swapCount += 2;
                        reverseLine.remove(reverseLine.size()-3);
                    }
                }
        }

        if (!isTooChaotic) {
            System.out.println(swapCount);
        }
    }


}
