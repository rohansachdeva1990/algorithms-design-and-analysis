package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
  * * * 1
  * * 1 2
  * 1 2 3
  1 2 3 4

  How many rows? 4 (N)
  How many columns? ith row has N columns, but some are stars and some numbers. N - i stars and numbers from 1 to i
  What to print? *

 */
public class Pattern18 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        int i = 0;
        while (i < numRows) {

            int j = 0;
            while (j < numRows - i - 1) {
                System.out.print("* ");
                j++;
            }

            j = 0;
            while (j <= i) {
                System.out.print(j + 1 + " ");
                j++;
            }

            System.out.println();
            i++;
        }

    }
}
