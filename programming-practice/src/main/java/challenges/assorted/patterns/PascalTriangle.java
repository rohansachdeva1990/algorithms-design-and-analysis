package challenges.assorted.patterns;

/**
 * Create Pascal Triangle. Helps to understand the use of 2-D arrays.
 *
 * <p>
 * Foreg.
 * number = 5 (0 to 4)
 * <p>
 * 0         1
 * 1        1 1
 * 2       1 2 1
 * 3      1 3 3 1
 * 4     1 4 6 4 1
 */
public class PascalTriangle {

    public static void print(int number) {
        int pt[][] = new int[number][];
        for (int i = 0; i < number; i++) {
            pt[i] = new int[i + 1];
            pt[i][0] = 1;
            for (int j = 1; j < i; j++) {
                pt[i][j] = pt[i - 1][j - 1] + pt[i - 1][j];
            }
            pt[i][i] = 1;
        }

        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            int[] ptRow = pt[i];
            int len = ptRow.length;
            int spaces = number - len;
            for (int j = 0; j < spaces; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < len; j++) {
                sb.append(ptRow[j]).append(" ");
            }
            for (int j = 0; j < spaces; j++) {
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }


    public static void main(String[] args) {
        print(5);
    }

}
