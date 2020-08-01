package challenges.g4g.arrays;

import java.util.Arrays;

/**
 * Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 * <p>
 * Example:-
 * Input: [1, 2, 3, 4, 5, 6, 7]
 * Output: [3, 4, 5, 6, 7, 1, 2]
 */
public class RotateByNElements {

    public static void rotate(int[] arr, int d) {
        for (int i = 0; i < d; i++) {
            leftRotateByOne(arr);
        }
    }

    private static void leftRotateByOne(int[] arr) {
        int temp = arr[0];
        int i;
        for (i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}
