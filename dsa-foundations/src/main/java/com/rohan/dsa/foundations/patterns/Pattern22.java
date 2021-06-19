package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
    4 4 4 4
    3 3 3
    2 2
    1

  How many rows? 4 (N)
  How many columns? num columns are decreasing, N - i (+ 1, when 1 starts from 1)
  What to print? *

 */
public class Pattern22 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        int i = 0;
        while (i < numRows) {
            int j = 0;
            while (j < numRows - i) {
                System.out.print(numRows - i + " ");
                j++;
            }

            System.out.println();
            i++;
        }
    }
}
