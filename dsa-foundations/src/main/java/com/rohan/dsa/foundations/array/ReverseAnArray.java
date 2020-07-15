package com.rohan.dsa.foundations.array;

import java.util.Stack;

/**
 * Write a program to reverse the array.
 */
public class ReverseAnArray {

    public void reverseArrayUsingStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int item : arr) {
            stack.push(item);
        }
        int i = 0;
        while (!stack.isEmpty()) {
            arr[i] = stack.pop();
            i++;
        }
    }

    public void reverseArrayUsingTempArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int j = 0, i = arr.length - 1; i >= 0; j++, i--) {
            reversed[j] = arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = reversed[i];
        }
    }

    public void reverseArrayUsingIndices(int[] arr) {
        int beg = 0;
        int end = arr.length - 1;
        int mid = isEven(arr.length) ? (beg + end) / 2 + 1 : (beg + end) / 2;
        while (true) {

            if (beg == mid) {
                break;
            }

            // swap
            int temp = arr[beg];
            arr[beg] = arr[end];
            arr[end] = temp;

            beg++;
            end--;
        }
    }

    private boolean isEven(int element) {
        return element % 2 == 0;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ReverseAnArray util = new ReverseAnArray();

        int[] arrOdd = {1, 2, 3, 4, 5};
        int[] arrEven = {1, 2, 3, 4, 5, 6};

        util.reverseArrayUsingIndices(arrOdd);
        util.reverseArrayUsingIndices(arrEven);

        printArray(arrOdd);
        printArray(arrEven);
    }
}
