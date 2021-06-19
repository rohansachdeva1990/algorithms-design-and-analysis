package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
  A B C D
  A B C D
  A B C D
  A B C D

  How many rows? 4 (N)
  How many columns? 4 (N)
  What to print? 'A' + column number

 */
public class Pattern12 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        int i = 0;
        while (i < numRows) {
            int j = 0;
            while (j < numRows) {
                char ch = (char) ('A' + j);
                System.out.print(ch + " ");
                j++;
            }
            System.out.println();
            i++;
        }

    }
}
