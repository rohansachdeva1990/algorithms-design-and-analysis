package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
  A
  B C
  C D E
  D E F G

  How many rows? 4 (N)
  How many columns? i row number
  What to print?

 */
public class Pattern15 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        int i = 0;
        while (i < numRows) {
            char startingChar = (char) ('A' + i);
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
