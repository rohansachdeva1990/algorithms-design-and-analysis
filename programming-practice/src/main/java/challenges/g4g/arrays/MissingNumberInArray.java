package challenges.g4g.arrays;

import java.util.Arrays;

/**
 * Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing,
 * the missing number is to be found.
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. For each test
 * case first line contains N(size of array). The subsequent line contains N-1 array elements.
 * <p>
 * Output:
 * Print the missing number in array.
 * <p>
 * Constraints:
 * 1 ≤ T ≤ 200
 * 1 ≤ N ≤ 107
 * 1 ≤ C[i] ≤ 107
 * <p>
 * Example:
 * Input:
 * 2
 * 5
 * 1 2 3 5
 * 10
 * 1 2 3 4 5 6 7 8 10
 * <p>
 * Output:
 * 4
 * 9
 * <p>
 * Explanation:
 * Testcase 1: Given array : 1 2 3 5. Missing element is 4.
 */
public class MissingNumberInArray {

    private static int findMissing(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i + 1] - arr[i] > 1) {
                return arr[i] + 1;
            }
        }
        return -1;
    }

    public static int findMissingUsingSum(int[] arr, int n) {
        int sumNatural = (n * (n + 1)) / 2;
        int sumElements = Arrays.stream(arr).sum();
        return sumNatural - sumElements;
    }

    // New Way
    public static int findMissingUsingXOR(int[] arr, int n) {
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            res = res ^ arr[i];
            res = res ^ (i + 1);
        }
        return (res ^ n);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        // int missing = findMissing(arr);
        // int  missing = findMissingUsingSum(arr, 5);
        int missing = findMissingUsingXOR(arr, 5);
        System.out.println(String.format("Missing number in Array: %s is %d", Arrays.toString(arr), missing));
    }
}
