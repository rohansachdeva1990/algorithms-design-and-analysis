package challenges.g4g.arrays;

import java.util.Arrays;

/**
 * QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot. There are many different versions of quickSort that pick pivot in different ways.
 * <p>
 * Always pick first element as pivot.
 * Always pick last element as pivot (implemented below)
 * Pick a random element as pivot.
 * Pick median as pivot.
 * The key process in quickSort is partition(). Target of partitions is, given
 * an array and an element x of array as pivot, put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, and put all greater elements (greater than x) after x. All this should be done in linear tim
 */
public class QuickSort {
    public void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private void quickSortHelper(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int partition = partition(arr, start, end);
        quickSortHelper(arr, start, partition - 1);
        quickSortHelper(arr, partition + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        // Pick rightmost element as pivot from the array
        int pivot = arr[end];

        // elements less than pivot will be pushed to the left of pIndex
        // elements more than pivot will be pushed to the right of pIndex
        // equal elements can go either way
        int pIndex = start;

        // each time we finds an element less than or equal to pivot,
        // pIndex is incremented and that element would be placed
        // before the pivot.
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }

        // swap pIndex with Pivot
        swap(arr, end, pIndex);

        // return pIndex (index of pivot element)
        return pIndex;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        QuickSort qSort = new QuickSort();

        int[] arr = {7, 6, 10, 5, 9, 2, 1, 15, 7};
        qSort.quickSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}