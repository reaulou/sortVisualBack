package com.reaulou.sortvis;

import java.util.Vector;

public class InsertionSort extends Sort{
    public void sort(int arr[], Vector<Integer> swaps)
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                swap(swaps,arr,j + 1, j);
                j = j - 1;
                printArray(arr);
            }
            printArray(arr);
        }
    }
}
