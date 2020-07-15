package com.rohan.dsa.foundations.array;

/**
 * Move all negative numbers to beginning and positive to end with
 * constant extra space
 */
public class NegativeElementsToOneSide {

    private static void rearrange(int[] arr) {
        int n = arr.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0 && j != i) {
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, -3, 4, 5, 6, -7, 8, 9};

        rearrange(arr);
        printArray(arr);
    }

}
