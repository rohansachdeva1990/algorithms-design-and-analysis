package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
  4 3 2 1
  4 3 2 1
  4 3 2 1
  4 3 2 1

  How many rows? 4 (N)
  How many columns? 4 (N)
  What to print? N - j  + 1, when j starts from 1 else N - j, if 0

 */
public class Pattern5 {

    private static void printWay1(int numRows) {
        int i = 0;
        while (i < numRows) {
            int j = numRows;
            while (j > 0) {
                System.out.print(j + " ");
                j--;
            }
            System.out.println();
            i++;
        }
    }

    private static void printWay2(int numRows) {
        int i = 0;
        while (i < numRows) {
            int j = 0;
            while (j < numRows) {
                System.out.print(numRows - j + " ");
                j++;
            }
            System.out.println();
            i++;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        printWay1(numRows);
        System.out.println();
        printWay2(numRows);
    }
}
