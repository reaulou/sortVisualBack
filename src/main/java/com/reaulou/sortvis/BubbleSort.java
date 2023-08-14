package com.reaulou.sortvis;

import java.util.Vector;

public class BubbleSort extends Sort{
    public void sort(int arr[], Vector<Integer> swaps)
    {
        int n = arr.length;
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(swaps, arr,j ,j+1);
                    swapped = true;
                }
            }

            if (swapped == false)
                break;
        }
    }
}
