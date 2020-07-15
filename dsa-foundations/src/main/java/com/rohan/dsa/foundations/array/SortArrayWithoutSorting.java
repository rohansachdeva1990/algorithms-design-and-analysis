package com.rohan.dsa.foundations.array;

/**
 * Given an array which consists of only 0, 1 and 2. Sort the array without
 * using any sorting algorithm.
 */
public class SortArrayWithoutSorting {

    public void sort(int[] arr) {
        int[] counters = new int[3];
        for (int i = 0; i < arr.length; i++) {
            counters[arr[i]] += 1;
        }

        int i = 0;
        for (int c = 0; c < 3; c++) {
            for (int j = 0; j < counters[c]; j++, i++) {
                arr[i] = c;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 2, 1, 0, 0, 1, 0, 0, 1, 2};
        new SortArrayWithoutSorting().sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
