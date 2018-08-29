package algo;

/**
 * Created by vikasnaiyar on 29/08/18.
 */
public class MergeNSortedArrays {

    public static void main(String[] args) {
        int[] a1 = {5,6,7,8};
        int[] a2 = {1,4,9, 10};
        int[] a3 = {2,3,11,12};

        int[] result = new int[a1.length * 3];
        int[] minHeap = new int[3];

        int i1=0, i2 =0, i3=0;

        for (int i=0; i<a1.length*3; i++) {

               int count = 0;
               if(i1 < a1.length) {
                   minHeap[count] = a1[i1];
                   ++count;
               }

                if(i2 < a2.length) {
                    minHeap[count] = a2[i2];
                    ++count;
                }


            if(i3 < a3.length) {
                minHeap[count] = a3[i3];
                ++count;
            }

               for (int j=count/2-1; j>=0; j--) {
                   heapify(minHeap,j, count);
               }

              result[i] = minHeap[0];

              if(i1 < a1.length && result[i] == a1[i1]) {
                  i1++;
              } else if(i2 < a2.length && result[i] == a2[i2]) {
                  i2++;
              } else {
                  i3++;
              }

              System.out.print(result[i] + ", ");
        }
    }

    public static void heapify(int[] heap, int i, int n) {

        int smallest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if(leftChild < n && heap[leftChild] < heap[smallest]) {
            smallest = leftChild;
        }

        if(rightChild < n && heap[rightChild] < heap[smallest]) {
            smallest = rightChild;
        }

         if(smallest != i) {
             int temp = heap[i];
             heap[i] = heap[smallest];
             heap[smallest] = temp;
             heapify(heap,smallest, n);
         }
    }
}
