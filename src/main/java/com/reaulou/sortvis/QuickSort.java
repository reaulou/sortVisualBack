package com.reaulou.sortvis;

import java.util.Vector;

public class QuickSort extends Sort{

    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    private int partition(Vector<Integer> swaps, int[] arr, int low, int high)
    {
        // Choosing the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (arr[j] < pivot) {

                // Increment index of smaller element
                i++;
                swap(swaps, arr, i, j);
            }
        }
        swap(swaps, arr, i + 1, high);
        return (i + 1);
    }

    // The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    private void quickSort(Vector<Integer> swaps, int[] arr, int low, int high)
    {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(swaps, arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(swaps, arr, low, pi - 1);
            quickSort(swaps, arr, pi + 1, high);
        }
    }

    // Driver Code
    public void sort(int arr[], Vector<Integer> swaps)
    {
        int l = arr.length;
        quickSort(swaps, arr, 0, l - 1);
    }
}
