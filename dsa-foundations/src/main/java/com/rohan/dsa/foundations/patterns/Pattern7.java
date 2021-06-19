package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
  1
  2 3
  3 4 5
  4 5 6 7

  How many rows? 4 (N)
  How many columns? i columns
  What to print? A starting number which is initialized every time with the row number value.

 */
public class Pattern7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        int i = 0;
        while (i < numRows) {
            int j = 0;
            int startingNumber = i + 1;
            while (j <= i) {
                System.out.print(startingNumber + " ");
                startingNumber++;
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
