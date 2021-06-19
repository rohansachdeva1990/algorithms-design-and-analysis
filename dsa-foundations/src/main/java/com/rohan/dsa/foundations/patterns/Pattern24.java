package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
         *
       * * *
     * * * * *
   * * * * * * *

  How many rows? N
  How many columns?  spaces (N - i) + stars from 1 to i + stars from i - 1 to 1
  What to print? combination of stars and spaces

 */
public class Pattern24 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        int i = 0;
        while (i < numRows) {

            // Print initial spaces
            int j = 0;
            while (j < numRows - i) {
                System.out.print(" ");
                j++;
            }

            // Print stars increasing
            j = 0;
            while (j <= i) {
                System.out.print("* ");
                j++;
            }

            // Print stars decreasing
            j = i - 1;
            while (j >= 0) {
                System.out.print("* ");
                j--;
            }
            System.out.println();
            i++;
        }
    }
}
