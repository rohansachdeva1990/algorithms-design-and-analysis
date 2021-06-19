package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
          *
        * *
      * * *
    * * * *
  * * * * *

  How many rows? 4 (N)
  How many columns? ith row has N columns, but some are spaces and some spaces. N - i spaces and i stars
  What to print? *

 */
public class Pattern17 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        int i = 1;
        while (i <= numRows) {

            // 1st loop to print spaces
            int j = 1;
            while (j <= numRows - i) {
                System.out.print(" ");
                j++;
            }

            // 2nd loop to print stars
            j = 1;
            while (j <= i) {
                System.out.print("*");
                j++;
            }

            System.out.println();
            i++;
        }
    }
}
