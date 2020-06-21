package com.rohan.dsa.foundations.sorting;

/**
 * Least Significant Digit Radix Sort
 */
public class LSDRadixSort {

    public static void sort(String[] a, int W) {
        int R = 256; // radix
        int N = a.length;
        String[] aux = new String[N];

        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R];

            // Create frequency table
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d)]++;
            }

            // Convert to position
            for (int i = 1; i < R; i++) {
                count[i] += count[i - 1];
            }

            for (int i = N - 1; i >= 0; i--) {
                int insertIndex = --count[a[i].charAt(d)];
                aux[insertIndex] = a[i];
            }
            // copy
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }

    private static void print(String[] arr) {
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] input = {
                "aab",
                "bba",
                "aba",
                "baa",
                "bbb",
                "aaa",
                "bab"
        };

        sort(input, 3);
        print(input);
    }

}
