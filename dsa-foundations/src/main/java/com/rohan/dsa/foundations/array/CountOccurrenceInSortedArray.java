package com.rohan.dsa.foundations.array;

public class CountOccurrenceInSortedArray {

    public int countOccurrence(int[] arr, int element) {

        int index = binarySearch(arr, element);

        if (index == -1) return 0;
        int count = 1;

        // count element on the left side
        int left = index - 1;
        while (left >= 0 && arr[left] == element) {
            count++;
            left--;
        }

        // count element on the right side
        int right = index + 1;
        while (right < arr.length && arr[right] == element) {
            count++;
            right++;
        }

        return count;
    }

    private int binarySearch(int[] arr, int key) {
        int beg = 0;
        int end = arr.length - 1;
        while (beg <= end) {
            int mid = (beg + end) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CountOccurrenceInSortedArray obj = new CountOccurrenceInSortedArray();
        int[] arr = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        System.out.println(obj.countOccurrence(arr, 8));
    }
}
