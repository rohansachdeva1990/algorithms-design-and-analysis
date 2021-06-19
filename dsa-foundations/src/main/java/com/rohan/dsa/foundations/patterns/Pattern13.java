package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
  A B C D
  B C D E
  C D E F
  D E F G

  How many rows? 4 (N)
  How many columns? 4 (N)
  What to print? Use a starting character and increment it with every row.

 */
public class Pattern13 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        // Way 1
        {
            int i = 0;
            char startingChar = 'A';
            while (i < numRows) {
                int j = 0;
                while (j < numRows) {
                    char ch = (char) (startingChar + j);
                    System.out.print(ch + " ");
                    j++;
                }
                System.out.println();
                startingChar++;
                i++;
            }
        }
        System.out.println();

        // Way 2
        {
            int i = 0;
            while (i < numRows) {
                int j = 0;
                char startingChar = (char) ('A' + i);
                while (j < numRows) {
                    char ch = (char) (startingChar + j);
                    System.out.print(ch + " ");
                    j++;
                }
                System.out.println();
                i++;
            }
        }
    }
}
