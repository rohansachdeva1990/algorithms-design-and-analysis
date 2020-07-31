package challenges.assorted.ctci.arrays;

/**
 * Category: Arrays & Strings
 * <p>
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to 0.
 * <p>
 * <p>
 * Approach 1:
 * - Keep track of rows and columns having 0s
 */
public class ZeroMatrix {

    public static void zeroMatrix(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        // Mark the zeros
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < columns.length; j++) {
                if (matrix[i][j] == 0) {
                    // mark row and column
                    rows[i] = true;
                    columns[i] = true;
                }
            }
        }

        // Check every row
        for (int i = 0; i < rows.length; i++) {
            if (rows[i]) {
                zeroifyRow(matrix, i);
            }
        }

        // Check every row
        for (int j = 0; j < columns.length; j++) {
            if (columns[j]) {
                zeroifyColumn(matrix, j);
            }
        }
    }

    private static void zeroifyRow(int[][] matrix, int rowIndex) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[rowIndex][j] = 0;
        }
    }

    private static void zeroifyColumn(int[][] matrix, int columnIndex) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][columnIndex] = 0;
        }
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1, 1},
                {2, 0, 2, 2},
                {3, 3, 3, 0},
                {4, 4, 4, 4}
        };
        printMatrix(matrix);
        zeroMatrix(matrix);
        printMatrix(matrix);

    }
}
