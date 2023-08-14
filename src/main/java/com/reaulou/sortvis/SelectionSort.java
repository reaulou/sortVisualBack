package com.reaulou.sortvis;

import java.util.Vector;

public class SelectionSort extends Sort{
    public void sort(int arr[], Vector<Integer> swaps)
    {
        int n = arr.length;

        for (int i = 0; i < n-1; i++)
        {
            int min = i;
            for (int j = i+1; j < n; j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }

            swap(swaps, arr, min, i);
        }
    }
}
