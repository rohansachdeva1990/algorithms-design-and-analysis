package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
   * * * * * * *
     * * * * *
       * * *
         *

  How many rows? N
  How many columns?
  What to print? combination of stars and spaces

 */
public class Pattern28 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        for (int i = numRows; i >= 1; i--) {

            for (int space = 1; space <= numRows - i; space++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}
