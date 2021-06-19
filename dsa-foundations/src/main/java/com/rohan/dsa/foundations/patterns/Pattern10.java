package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
  1
  2 2
  3 3 3
  4 4 4 4

  How many rows? 4 (N)
  How many columns? i columns
  What to print? i value

 */
public class Pattern10 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        int i = 0;
        while (i < numRows) {
            int j = 0;
            while (j <= i) {
                System.out.print(i + 1 + " ");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
