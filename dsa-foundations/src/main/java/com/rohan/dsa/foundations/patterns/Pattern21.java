package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
    * * * *
      * * *
        * *
          *

  How many rows? 4 (N)
  How many columns? num columns are decreasing, N - i (+ 1, when 1 starts from 1)
  What to print? *

 */
public class Pattern21 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        int i = 0;
        while (i < numRows) {
            int j = 0;
            // 1st loop to print spaces
            while (j <= i) {
                System.out.print("  ");
                j++;
            }

            j = 0;
            // 2nd loop to print
            while (j < numRows - i) {
                System.out.print("* ");
                j++;
            }

            System.out.println();
            i++;
        }
    }
}
