package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
  1 2 3 4
  1 2 3 4
  1 2 3 4
  1 2 3 4

  How many rows? 4 (N)
  How many columns? 4 (N)
  What to print? j; Which is column number

 */
public class Pattern4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();
        int i = 0;
        while (i < numRows) {
            int j = 0;
            while (j < numRows) {
                System.out.print(j + 1 + " ");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
