package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
  1
  1 2
  1 2 3
  1 2 3 4

  How many rows? 4 (N)
  How many columns? i columns (same as ith row)
  What to print? j; column number

 */
public class Pattern6 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        int i = 0;
        while (i < numRows) {
            int j = 0;
            while (j <= i) {
                System.out.print(j + 1 + " ");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
