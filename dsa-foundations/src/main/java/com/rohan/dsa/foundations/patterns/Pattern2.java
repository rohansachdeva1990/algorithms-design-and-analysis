package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
  1 1 1 1
  2 2 2 2
  3 3 3 3
  4 4 4 4

  How many rows? 4 (N)
  How many columns? 4 (N)
  What to print? i; Which is row number

 */
public class Pattern2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();


        int i = 0;
        while (i < numRows) {
            int j = 0;
            while (j < numRows) {
                System.out.print(i + 1);
                j++;
            }
            System.out.println();
            i++;
        }


    }
}
