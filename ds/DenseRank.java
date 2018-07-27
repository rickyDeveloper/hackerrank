import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikasnaiyar on 27/07/18.
 */
public class DenseRank {

    public static void main(String[] args) {


        List<Integer> input = new ArrayList<>();
        input.add(100);
        input.add(50);
        input.add(40);
        input.add(20);
        input.add(10);


        List<Integer> alice = new ArrayList<>();
        alice.add(5);
        alice.add(25);
        alice.add(50);
        alice.add(120);


        alice.stream().forEach( i -> {

            System.out.println(1 + doBinarySearch(input,i,0,input.size()-1));

        });


    }

    private static int doBinarySearch(List<Integer> input, int data, int left, int right) {

         int index = -1;

         if(left > right) {
             return left;
         } else if(right < left) {
             return right;
         }

          int mid = left + (right - left)/2;

          if(input.get(mid) == data) {
              index = mid;
          } else if(input.get(mid)> data){
              left = mid +1;
              index = doBinarySearch(input,data,left,right);
          } else {
              right = mid -1;
              index = doBinarySearch(input,data,left,right);
          }

          if(index == -1) {
              input.add(0, data);
          } else if(index == input.size() || input.get(index) != data) {
              input.add(index, data);
          }

          return  index;
    }
}
