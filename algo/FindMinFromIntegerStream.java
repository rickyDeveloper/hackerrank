package algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikasnaiyar on 20/09/18.
 */
public class FindMinFromIntegerStream {


    public static void main(String[] args) {

        int[] stream = {-5,4,-2,3,1, -1, -6, -1, 0, -5};



        System.out.println(minPower(stream));


       /* int[] stream = {14,5,19,1,17, 7, 23, 95, 67};

        List<Integer>  heap = new ArrayList<>();

        for (int num: stream) {
            heap.add(num);
            minHeapify(heap);
        }

        System.out.println(heap);

        heap.remove(2);
        minHeapify(heap);


        System.out.println(heap);*/
    }


    public static int minPower(int[]  p) {
        // Write your code here
        int lastIndex = p.length -1;
        int min = 1;
        while(lastIndex >=0) {
            int power = p[lastIndex];
            if(power < 0) {
                min += Math.abs(power);
            } else {
                if(power < min) {
                    min =  min - power;
                } else {
                    min = 1;
                }
            }
            --lastIndex;
        }

        return min;

    }

    private static void minHeapify(List<Integer> heap) {
        int n = heap.size();
        int mid = n / 2 ;
        for (int i=n/2 - 1; i>=0; i--) {
            int leftChildIndex = 2 * i  + 1;
            int rightChildIndex = 2 * i + 2;

            int smallest= i;

            if(leftChildIndex < n && heap.get(leftChildIndex) < heap.get(smallest) ) {
                smallest = leftChildIndex;
            }


            if(rightChildIndex < n && heap.get(rightChildIndex) < heap.get(smallest)) {
                smallest = rightChildIndex;
            }

            if(smallest != i) {
                int temp = heap.get(smallest);
                heap.set(smallest, heap.get(i));
                heap.set(i, temp);
            } else {
                break;
            }
        }
    }


}
