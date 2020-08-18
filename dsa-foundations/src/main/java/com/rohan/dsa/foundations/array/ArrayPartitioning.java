package com.rohan.dsa.foundations.array;

import java.util.Arrays;

// Partitioning around 0
public class ArrayPartitioning {

    private static final int PIVOT = 0;

    public int[] partitionWay1(int[] arr) {

        // Intentionally creating pArr (Not required, only for debugging purpose)
        int[] pArr = Arrays.copyOf(arr, arr.length);
        int pIndex = 0;

        for (int i = 0; i < pArr.length; i++) {
            if (pArr[i] < PIVOT) {
                int temp = pArr[i];
                pArr[i] = pArr[pIndex];
                pArr[pIndex] = temp;
                pIndex++;
            }
        }

        System.out.println("Partition Index: " + pIndex);
        return pArr;
    }

    public int[] partitionWay2(int[] arr) {

        int[] pArr = Arrays.copyOf(arr, arr.length);

        int low = 0;
        int high = pArr.length - 1;

        while (low < high) {

            while (pArr[low] <= PIVOT) {
                low++;
            }

            while (pArr[high] > PIVOT) {
                high--;
            }

            if (low < high) {
                int temp = pArr[low];
                pArr[low] = pArr[high];
                pArr[high] = temp;
            }
        }

        System.out.println("Partition Index: " + low);

        return pArr;
    }


    public static void main(String[] args) {
        int[] arr = {9, -3, 5, -2, -8, -6, 1, 3};
        System.out.println("Before: " + Arrays.toString(arr));
        ArrayPartitioning arrayPartitioning = new ArrayPartitioning();

        int[] partitionArray = arrayPartitioning.partitionWay1(arr);
        System.out.println("After way 1: " + Arrays.toString(partitionArray));

        partitionArray = arrayPartitioning.partitionWay2(arr);
        System.out.println("After way 2: " + Arrays.toString(partitionArray));
    }
}
