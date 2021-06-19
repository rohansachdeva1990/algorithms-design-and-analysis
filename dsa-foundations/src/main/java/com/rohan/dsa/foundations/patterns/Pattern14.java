package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
  A
  B B
  C C C
  D D D D

  How many rows? 4 (N)
  How many columns? i row number
  What to print? A + i

 */
public class Pattern14 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        int i = 0;
        while (i < numRows) {
            int j = 0;
            while (j <= i) {
                char ch = (char) ('A' + i);
                System.out.print(ch + " ");
                j++;
            }
            System.out.println();
            i++;
        }

    }
}
