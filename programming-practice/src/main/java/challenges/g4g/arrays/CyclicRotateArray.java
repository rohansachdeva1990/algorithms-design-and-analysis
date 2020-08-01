package challenges.g4g.arrays;

import java.util.Arrays;

/**
 * Given an array, cyclically rotate an array by one.
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test
 * cases. Then T test cases follow. Each test case contains an integer n denoting
 * the size of the array. Then following line contains 'n' integers forming the array.
 * <p>
 * Output:
 * Output the cyclically rotated array by one.
 * <p>
 * Constraints:
 * 1<=T<=1000
 * 1<=N<=1000
 * 0<=a[i]<=1000
 * <p>
 * Example:
 * Input:
 * 2
 * 5
 * 1 2 3 4 5
 * 8
 * 9 8 7 6 4 2 1 3
 * <p>
 * Output:
 * 5 1 2 3 4
 * 3 9 8 7 6 4 2 1
 */
public class CyclicRotateArray {

    public static void rotate(int[] arr) {
        int temp = arr[arr.length - 1];
        int i;
        for (i = arr.length - 1; i >= 1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[i] = temp;
    }


    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {9, 8, 7, 6, 4, 2, 1, 3};
        System.out.println(Arrays.toString(arr));
        rotate(arr);
        System.out.println(Arrays.toString(arr));
    }
}
