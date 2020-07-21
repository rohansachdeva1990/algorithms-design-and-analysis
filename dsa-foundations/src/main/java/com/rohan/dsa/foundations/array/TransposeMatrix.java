package com.rohan.dsa.foundations.array;

/**
 * Transpose of matrix:
 * <p>
 * - Change rows to column
 */
public class TransposeMatrix {

    private int[][] matrix;
    private int N;

    public TransposeMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.N = matrix.length;
    }

    public void transpose() {
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
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
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };


        int[][] matrix1 = {
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}
        };

        TransposeMatrix transposeMatrix = new TransposeMatrix(matrix1);
        transposeMatrix.transpose();
        transposeMatrix.printMatrix();
    }

}
