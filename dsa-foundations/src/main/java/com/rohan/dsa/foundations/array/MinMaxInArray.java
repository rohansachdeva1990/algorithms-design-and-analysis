package com.rohan.dsa.foundations.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * Find the minimum and maximum element in an array.
 */
public class MinMaxInArray {

    public int min(int[] arr) {
        int min = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        return arr[min];
    }

    public int minUsingCollections(Integer[] arr) {
        return Collections.min(Arrays.asList(arr));
    }


    public int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public int maxUsingCollections(Integer[] arr) {
        return Collections.max(Arrays.asList(arr));
    }

}
