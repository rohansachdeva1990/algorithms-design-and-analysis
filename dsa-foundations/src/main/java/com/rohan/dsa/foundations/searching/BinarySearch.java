package com.rohan.dsa.foundations.searching;

public class BinarySearch {

    public int binarySearch(int[] arr, int key) {
        int beg = 0;
        int last = arr.length - 1;
        int mid;
        while (true) {
            mid = (beg + last) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (beg > last) {
                break;
            } else {
                if (arr[mid] < key) {
                    // It is present in the next half
                    beg = mid + 1;
                } else {
                    last = mid - 1;
                }
            }
        }
        return -1;
    }

    public int binarySearchRecursive(int[] arr, int key, int min, int max) {
        if (max <= min) {
            return -1;
        } else {
            int mid = (min + max) / 2;

            if (arr[mid] < key) {
                binarySearchRecursive(arr, key, mid + 1, max);
            } else if (arr[mid] > key) {
                binarySearchRecursive(arr, key, min, mid - 1);
            } else {
                return mid;
            }
        }

        return -1;
    }

}
