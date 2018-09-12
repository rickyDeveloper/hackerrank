package algo;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vikasnaiyar on 12/09/18.
 */
public class FraudulentActivityNotifications {

    public static void main(String[] args) {
        int[] expenditure = {2, 3, 4, 2, 3, 6, 8, 4, 5};
        //2 2 3 3 4  == 3   -- 1
        //2 3 3 4 6  == 3   -- 1
        //3 3 4 6 8  == 4   -- 0
        //3 4 5 6 8  == 5   -- 0

        //int[] expenditure = {1 ,2 ,3, 4, 4};
        int d = 5;

        //System.out.println(activityNotifications(expenditure, d));
        test(expenditure,d);
    }

    static void test(int[] expenditure, int d) {
        int[] hash = new int[210];
        int n = expenditure.length;
        int[] a =  new int[n];
        if (d>=n) {
            System.out.println(0);
            return;
        }
        for(int i=0; i<d; i++){
            a[i]=expenditure[i];
            hash[a[i]]++;
        }
        int sol=0;
        for(int i=d; i<n; i++){
            a[i] = expenditure[i];
            int count=0;
            double ans=0;
            for(int j=0; j<210; j++){
                count+=hash[j];

                if (2*count>=d) {
                    if (2*count==d){
                        //if (hash[j]==0) continue;
                        ans=j;
                    } else{
                        if(ans!=0){
                            ans=(ans+j)/2;
                        } else{
                            ans=j;
                        }
                        //ans=j;
                        break;
                    }

                }

            }

            // System.out.println(ans+" "+a[i]);
            if (a[i]>=2*ans) sol++;

            hash[a[i]]++;
            hash[a[i-d]]--;
        }
        System.out.println(sol);
    }

    /**
     * This is going to be slow as we are using collections.
     * @param expenditure
     * @param d
     * @return
     */
    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        List<Integer> a = new LinkedList<>();
        for(int i=0; i<d; i++) {
            a.add(expenditure[i]);
        }

        int mid1, mid2 = -1;
        double currentMedian = 0;
        int n = expenditure.length;
        if(d == 1) {
            mid1 = 0;
        } else {
            mid1 = d/2;
            if(d % 2 ==0) {
                mid2 = mid1 - 1;
            }
        }

        int medianBreachedCount = 0;
        Collections.sort(a);

        for(int i=d; i< n; i++) {
            if(mid2 != -1) {
                currentMedian = (a.get(mid1) + a.get(mid2))/2.0;
            } else {
                currentMedian = a.get(mid1);
            }

            if(expenditure[i] >= 2 * currentMedian) {
                ++medianBreachedCount;
            }

            final int index = i;
            final AtomicInteger traverseIndex = new AtomicInteger(-1);
            final Integer indexRemove = null;
            final Integer indexAdd = new Integer(0);
            //((LinkedList)a).removeFirstOccurrence(new Integer(expenditure[i-d]));
            a.stream().forEach(z -> {
                    traverseIndex.getAndIncrement();
                    if(indexRemove == null && z.intValue() == expenditure[index-d]) {
                        //indexRemove += new Integer(traverseIndex.intValue());
                    }

            });



        }

        return medianBreachedCount;
    }

}
