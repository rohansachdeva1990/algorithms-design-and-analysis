package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*

  E
  D E
  C D E
  B C D E
  A B C D E

  How many rows? 4 (N)
  How many columns? i row number
  What to print? starting character beginning with E and incrementing on every column count

 */
public class Pattern16 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        int i = 0;
        while (i < numRows) {
            char startingChar = (char) ('E' - i);
            int j = 0;
            while (j <= i) {
                char ch = (char) (startingChar + j);
                System.out.print(ch + " ");
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
