package com.rohan.dsa.foundations.array;

import java.util.Arrays;

/**
 * Given an array and a number k where k is smaller than size of array, we need to
 * find the k’th smallest element in the given array. It is given that'll array
 * elements are distinct.
 * <p>
 * Below is the naive solution. Check heap section for more sophisticated way
 */
public class KthLargestSmallestInArray {

    public static int kthLargest(int[] arr, int k) {
        if (k > arr.length) {
            throw new IllegalArgumentException();
        }

        Arrays.sort(arr);
        return arr[arr.length - k];
    }


    public static int kthSmallest(int[] arr, int k) {
        if (k > arr.length) {
            throw new IllegalArgumentException();
        }

        Arrays.sort(arr);
        return arr[k - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 9, 6, 33, 19};

        System.out.println("largest: " + kthLargest(arr, 3));
        System.out.println("smallest: " + kthSmallest(arr, 3));

    }
}
