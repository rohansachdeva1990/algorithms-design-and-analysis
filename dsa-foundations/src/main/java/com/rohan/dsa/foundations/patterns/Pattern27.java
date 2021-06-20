package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
        *
       * *
      * * *
     * * * *
    * * * * *

  How many rows? N
  How many columns?  spaces (N - i) + stars from 1 to i + stars from i - 1 to 1
  What to print? combination of stars and spaces

 */
public class Pattern27 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        for (int i = 1; i <= numRows; i++) {

            for (int space = 1; space <= (numRows - i); space++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}
