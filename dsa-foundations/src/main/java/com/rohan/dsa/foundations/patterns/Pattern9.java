package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
  *
  * *
  * * *
  * * * *

  How many rows? 4 (N)
  How many columns? i columns
  What to print? "*"

 */
public class Pattern9 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        int i = 0;
        while (i < numRows) {
            int j = 0;
            while (j <= i) {
                System.out.print("* ");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
