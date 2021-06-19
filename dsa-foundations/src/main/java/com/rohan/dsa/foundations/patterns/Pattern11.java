package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
  1
  2 1
  3 2 1
  4 3 2 1

  How many rows? 4 (N)
  How many columns? i columns
  What to print? i value

 */
public class Pattern11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        // Way 1
        {
            int i = 0;
            while (i < numRows) {
                int j = i;
                while (j >= 0) {
                    System.out.print(j + 1 + " ");
                    j--;
                }
                System.out.println();
                i++;
            }
        }

        System.out.println();

        // Way 2
        {
            int i = 0;
            while (i < numRows) {
                int j = 0;
                while (j <= i) {
                    System.out.print(i - j + 1 + " ");
                    j++;
                }
                System.out.println();
                i++;
            }
        }
    }
}
