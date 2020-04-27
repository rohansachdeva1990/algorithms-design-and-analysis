package challenges.codechef;


import utilities.InputReaderHelper;
import utilities.OutputWriterHelper;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem Statement
 * <p>
 * There are 100 houses located on a straight line. The first house is numbered 1 and the last one is numbered 100.
 * Some M houses out of these 100 are occupied by cops.
 * Thief Devu has just stolen PeePee's bag and is looking for a house to hide in.  PeePee uses fast 4G Internet and
 * sends the message to all the cops that a thief named Devu has just stolen her bag and ran into some house.
 * <p>
 * Devu knows that the cops run at a maximum speed of x houses per minute in a straight line and they will search
 * for a maximum of y minutes. Devu wants to know how many houses are safe for him to escape from the cops. Help
 * him in getting this information.
 * <p>
 * Input
 * First line contains T, the number of test cases to follow.
 * First line of each test case contains 3 space separated integers: M, x and y.
 * For each test case, the second line contains M space separated integers which represent the house numbers where
 * the cops are residing.
 * <p>
 * Output
 * For each test case, output a single line containing the number of houses which are safe to hide from cops.
 * <p>
 * Constraints
 * 1 ≤ T ≤ 104
 * 1 ≤ x, y, M ≤ 10
 * Example
 * <p>
 * Input:
 * 3
 * 4 7 8
 * 12 52 56 8
 * <p>
 * 2 10 2
 * 21 75
 * <p>
 * 2 5 8
 * 10 51
 * <p>
 * Output:
 * 0
 * 18
 * 9
 * Explanation
 * Example 1 : Cops in house 12 can cover houses 1 to 68, and cops in house 52 can cover the rest of the houses.
 * So, there is no safe house.
 * Example 2 : Cops in house 21 can cover houses 1 to 41, and cops in house 75 can cover houses 55 to 95,
 * leaving houses numbered 42 to 54, and 96 to 100 safe. So, in total 18 houses are safe.
 */
public class CopsAndTheThiefDevu {
    public static void main(String[] args) {
        InputReaderHelper in = null;
        OutputWriterHelper out = null;
        try {
            in = new InputReaderHelper(System.in);
            out = new OutputWriterHelper(System.out);
            int numTestCases = in.readInt();
            while (numTestCases-- > 0) {
                int M = in.readInt();
                int x = in.readInt();
                int y = in.readInt();

                int detectRange = x * y;
                int hArr[] = in.readIntArray(M);

                Set<Integer> unsafeHouses = new HashSet<>();
                for (int i = 0; i < M; i++) {
                    int hLeft = hArr[i] - detectRange;
                    if (hLeft <= 0) {
                        hLeft = 1;
                    }
                    int hRight = (hArr[i] + detectRange);
                    if (hRight > 100) {
                        hRight = 100;
                    }
                    for (int j = hLeft; j <= hRight; j++) {
                        unsafeHouses.add(j);
                    }
                }
                out.println(100 - unsafeHouses.size());
            }
        } catch (Exception e) {
        } finally {
            if (in != null) {
                in.close();
            }
            if (null != out) {
                out.flush();
                out.close();
            }
        }
    }
}