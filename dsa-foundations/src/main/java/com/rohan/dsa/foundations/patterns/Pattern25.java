package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
         1
       2 3 2
     3 4 5 4 3
   4 5 6 7 6 5 4

  How many rows? N
  How many columns?  spaces (N - i) + nums from starting number(i) till i times + stars from i - 1 to 1
  What to print? numbers

 */
public class Pattern25 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        int i = 0;
        int startingNumber = 1;
        while (i < numRows) {

            // Print spaces
            int j = 0;
            while (j < numRows - i - 1) {
                System.out.print(" ");
                j++;
            }

            // Print numbers from starting number to starting number + i
            j = 0;
            while (j <= i) {
                System.out.print(startingNumber + j);
                j++;
            }

            // Needs more explanation
            // Print numbers from starting number + i - 1 till j reaches -1
            j = i - 1; // This is just used as a counter, can be initialized to 1 and we can go incrementing till i - 1
            int p = startingNumber + j;
            while (j >= 0) {
                System.out.print(p);
                p--;
                j--;
            }

            System.out.println();
            startingNumber++;
            i++;
        }
    }
}
