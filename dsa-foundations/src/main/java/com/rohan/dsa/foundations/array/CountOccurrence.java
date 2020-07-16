package com.rohan.dsa.foundations.array;

/**
 * Given a number n, Find the number of occurrences of n in the array
 */
public class CountOccurrence {

    public static int countOccurrence(int[] arr, int n) {
        int count = 0;
        for (int item : arr) {
            if (n == item) {
                count++;
            }
        }
        return count;
    }
}
