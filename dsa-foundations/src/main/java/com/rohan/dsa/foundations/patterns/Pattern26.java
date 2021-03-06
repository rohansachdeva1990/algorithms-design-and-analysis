package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
         *
       * * *
     * * * * *
   * * * * * * *
     * * * * *
       * * *
         *

  How many rows? N
  How many columns?
  What to print?

 Refer Pattern24 and Pattern28
 */
public class Pattern26 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        // Top diamond
        for (int i = 1; i <= numRows; i++) {

            for (int space = 1; space <= numRows - i; space++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Bottom diamond
        for (int i = numRows - 1; i >= 1; i--) {

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
