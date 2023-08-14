package com.reaulou.sortvis;

import java.util.Vector;

public abstract class Sort {
    public abstract void sort(int arr[], Vector<Integer> swaps);

    public void printArray(int arr[])
    {
        int l = arr.length;
        for (int i=0; i<l; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public void swap(Vector<Integer> swaps, int arr[], int j, int i){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;

        swaps.add(j);
        swaps.add(i);
    }

}
