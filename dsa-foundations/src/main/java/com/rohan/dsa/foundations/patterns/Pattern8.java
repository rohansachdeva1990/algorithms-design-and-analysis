package com.rohan.dsa.foundations.patterns;

import java.util.Scanner;

/*
  1
  2 3
  4 5 6
  7 8 9 10

  How many rows? 4 (N)
  How many columns? i columns
  What to print? counter is initialized once with the original value of i and is incremented
  number of times the all the loops will run

 */
public class Pattern8 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();

        int i = 0;
        int counter = i + 1;
        while (i < numRows) {
            int j = 0;
            while (j <= i) {
                System.out.print(counter + " ");
                counter++;
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
