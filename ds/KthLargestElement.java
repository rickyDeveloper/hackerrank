package com.naiyarv;

import java.util.Arrays;
import java.util.List;

/**
 * Created by vikasnaiyar on 24/07/18.
 */
public class KthLargestElement {

    public static void main(String[] args) {

        List<Integer> input = Arrays.asList(2, 2, 2, 3, 3, 4, 4, 5);

        List<Integer> minHeap = buildMinHeap(input);

    }


    public static List<Integer> buildMinHeap(List<Integer> minHeap) {

        int n = minHeap.size();

        int mid = n/2-1;

        for(int i=mid; i>=0; --i) {
            heapify(minHeap, i);
        }

        System.out.println(minHeap);

        return minHeap;

    }

    public static void heapify(List<Integer> minHeap, int i) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        int largest = i;

        if(leftChild < minHeap.size() && minHeap.get(leftChild) > minHeap.get(i)) {
            largest = leftChild;
        }

        if(rightChild < minHeap.size() && minHeap.get(rightChild) > minHeap.get(largest)) {
            largest = rightChild;
        }


        if(i != largest) {
            int temp = minHeap.get(i);
            minHeap.set(i, minHeap.get(largest));
            minHeap.set(largest, temp);

            // Recursively heapify the affected sub-tree
            heapify(minHeap, largest);
        }
    }

}
