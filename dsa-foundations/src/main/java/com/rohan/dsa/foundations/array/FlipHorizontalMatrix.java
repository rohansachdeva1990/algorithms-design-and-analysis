package com.rohan.dsa.foundations.array;

/**
 * Flipping a matrix horizontally
 */
public class FlipHorizontalMatrix {

    private int[][] matrix;
    private int N;

    public FlipHorizontalMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.N = matrix.length;
    }

    public void flipHorizontal() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N - j - 1];
                matrix[i][N - j - 1] = temp;
            }
            printMatrix();
        }
    }

    private void printMatrix() {
        System.out.println();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        int[][] matrix1 = {
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4}
        };

        FlipHorizontalMatrix flipHorizontalMatrix = new FlipHorizontalMatrix(matrix1);
        flipHorizontalMatrix.flipHorizontal();
        flipHorizontalMatrix.printMatrix();
    }

}
