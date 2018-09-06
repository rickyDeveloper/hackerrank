package algo;

/**
 * Created by vikasnaiyar on 06/09/18.
 */
public class MinimumSwaps2 {

    public static void main(String[] args) {

        //int[] inputs = {4, 3, 1, 2};
        //int[] inputs = {2, 3, 4, 1, 5};
        //int[] inputs = {7, 1, 3, 2, 4, 5, 6};

        int[] inputs =  {1, 3, 5, 2, 4, 6, 8};


            int c=0,n=inputs.length;
            for(int i=0;i<n;i++)
            {
                if(inputs[i]==(i+1))
                    continue;

                int temp1 = inputs[i];
                int temp2 = inputs[inputs[i]-1];
                inputs[i] = temp2;
                inputs[temp1-1] = temp1;

                c++;
                i--;
            }

        System.out.println("C --> " + c);


        n = inputs.length;
        int left = 0;
        int right = n - 1;
        int swapCount = 0;

        while (left < n && inputs[left] == left + 1) {
            ++left;
        }

        while (inputs[right] == right + 1 && right >= left) {
            --right;
        }

        while (left < right) {

            int min = n + 1;
            int swapI = -1;
            int swapJ = -1;
            boolean hasZero = false;

            for (int i = left; i < right; i++) {
                if (inputs[i] != i + 1) {
                    for (int j = i + 1; j <= right; j++) {
                        if (inputs[j] != j + 1) {
                            int m1 = Math.abs(inputs[i] - 1 - j);
                            int m2 = Math.abs(inputs[j] - 1 - i);

                            if (min == n + 1) {
                                min = m1 + m2;
                                swapI = i;
                                swapJ = j;
                                if (m1 == 0 || m2 == 0) {
                                    hasZero = true;
                                }
                            } else if (min > m1 + m2) {
                                min = m1 + m2;
                                swapI = i;
                                swapJ = j;
                                if (m1 == 0 || m2 == 0) {
                                    hasZero = true;
                                }
                            } else if (min == m1 + m2 && !hasZero && (m1 == 0 || m2 == 0)) {
                                hasZero = true;
                                swapI = i;
                                swapJ = j;
                            }
                        }
                    }

                }
            }

                if (swapI != -1 && swapJ != -1) {
                    int temp = inputs[swapI];
                    inputs[swapI] = inputs[swapJ];
                    inputs[swapJ] = temp;
                    ++swapCount;
                }



            while (left < n && inputs[left] == left + 1) {
                ++left;
            }

            while (inputs[right] == right + 1 && right >= left) {
                --right;
            }

        }

    }


}
