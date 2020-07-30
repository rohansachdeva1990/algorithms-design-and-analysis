package challenges.assorted.ctci.arrays;

/**
 * Category: Arrays & Strings
 * <p>
 * Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 * <p>
 * The algorithm involves 2 steps
 * 1. Convert first row to first column (transpose)
 * 2. Convert first column to last column (flip horizontally)
 */
public class RotateMatrix {

    private int[][] matrix;
    private int N;

    public RotateMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.N = matrix.length;
    }

    public void rotate() {
        transpose();
        flipHorizontally();
    }

    private void transpose() {
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void flipHorizontally() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N - 1 - j];
                matrix[i][N - 1 - j] = temp;
            }
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


        RotateMatrix rotateMatrix = new RotateMatrix(matrix1);
        rotateMatrix.printMatrix();
        rotateMatrix.rotate();
        rotateMatrix.printMatrix();

    }


}
