package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
        1
      1 2 1
    1 2 3 2 1
  1 2 3 4 3 2 1

  How many rows? N
  How many columns?  spaces (N - i) + nums from 1 to i + nums from i - 1 to 1
  What to print? numbers

 */
public class Pattern23 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        // Way 1
        {
            int i = 0;
            while (i < numRows) {

                // Print spaces
                int j = 0;
                while (j < numRows - i - 1) {
                    System.out.print(" ");
                    j++;
                }

                // Print number increasing from 1 to i
                j = 0;
                while (j <= i) {
                    System.out.print(j + 1);
                    j++;
                }

                // Print number decreasing from i - 1 to 1
                j = i - 1;
                while (j >= 0) {
                    System.out.print(j + 1);
                    j--;
                }

                System.out.println();
                i++;
            }
        }

        System.out.println();

        // Way 2
        {
            int i = 1;
            while (i <= numRows) {

                // Print spaces
                int spaces = 0;
                while (spaces < numRows - i) {
                    System.out.print(" ");
                    spaces++;
                }

                // Print number increasing from 1 to i
                int j = 1; // Use it as a counter
                int p = 1;
                while (j <= i) {
                    System.out.print(p);
                    p++;
                    j++;
                }

                // Print number decreasing from i - 1 to 1
                p = i - 1;
                j = 1;
                while (j <= i - 1) {
                    System.out.print(p);
                    p--;
                    j++;
                }

                System.out.println();
                i++;
            }
        }
    }
}
