package com.rohan.dsa.foundations.sorting;


import java.util.Arrays;

/**
 * Idea:-
 * <p>
 * - Divide the array in 2 logical groups - sorted and unsorted
 * - Initially the sorted list contains the first element and the unsorted contains the rest
 * - we choose a temp value. This temp value is the first element in the unsorted list
 * - By storing it in a temp variable, we create a hole so that it can be occupied by subsequents shift
 * - we compare the temp with sorted list from last index. If temp is less, then we right shift the sorted list
 * <p>
 * Time Complexity:-
 * Best Case: O(n), Sorted array; Inner while loop runs in O(1)
 * Worst Case: O(n^2)
 */
public class InsertionSort {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1; // Sorted list last index
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j]; // Shifting right
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] arr = {5, 4, 10, 1, 6, 2};
        insertionSort.sort(arr);
        Arrays.stream(arr).forEach(v -> System.out.print(v + " "));
    }
}
