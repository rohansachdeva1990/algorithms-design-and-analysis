package challenges.g4g.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array a[] of size N which contains elements from 0 to N-1, you need to find all the elements
 * occurring more than once in the given array.
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow.
 * Each test case contains an integer N which denotes the number of elements in the array. The second line
 * of each test case contains n space separated integers denoting elements of the array a[].
 * <p>
 * Output:
 * Print the duplicate elements from the given array. The order of the output should be in sorted order.
 * Print -1 if no duplicate exists.
 * <p>
 * Your Task:
 * Complete the function duplicates() which takes array a[] and n as input as parameters
 * and returns a list of elements that occur more than once in the given array in sorted manner.
 * If no such element is found return -1.
 * <p>
 * Expected Time Complexity: O(n).
 * Expected Auxiliary Space: O(n).
 * Note : The extra space is only for the array to be returned.
 * Try and perform all operation withing the provided array.
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 105
 * 0 <= A[i] <= N-1, for each valid i
 * <p>
 * Example:
 * Sample Input:
 * 2
 * 4
 * 0 3 1 2
 * 5
 * 2 3 1 2 3
 * <p>
 * Sample Output:
 * -1
 * 2 3
 * <p>
 * Explanation:
 * Testcase 1: N=4 and all elements from 0 to (N-1 = 3) are present in the given array. Therefore output is -1.
 * Testcase 2: 2 and 3 occur more than once in the given array.
 */
public class FindDuplicatesInArray {

    // Approach 1: Using 2 loops

    // Approach 2: Sort and check adjacent

    // Approach 3: Use frequency counter

    // Approach 4: Use seenOnce and seenMultiple map

    // Approach 5: Using input array as a hashmap, with given constraint 1 < a[i] < N
    public static List<Integer> findDuplicatesUsingNegation(int[] arr) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {

            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                output.add(index + 1);
            } else {
                arr[index] = -arr[index];
            }
        }

        if (output.isEmpty()) {
            output.add(-1);
        }
        return output;
    }

    // Approach 6: Learn this way
    public static ArrayList<Integer> findDuplicatesUsingIncrementByNWay1(int[] arr, int n) {
        // First check all the values that are
        // present in an array then go to that
        // values as indexes and increment by
        // the size of array
        for (int i = 0; i < n; i++) {
            int index = arr[i] % n;
            arr[index] += n;
        }

        // Now check which value exists more
        // than once by dividing with the size
        // of array
        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((arr[i] / n) > 1) {
                output.add(i);
            }
        }
        if (output.isEmpty()) {
            output.add(-1);
        }
        return output;
    }

    // Approach 6.1
    public static ArrayList<Integer> findDuplicatesUsingIncrementByNWay2(int[] arr, int n) {

        for (int i = 0; i < n; i++) {
            int index = arr[i] % n;
            arr[index] += n;
        }

        ArrayList<Integer> output = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > (n * 2)) {
                output.add(i);
            }
        }
        if (output.isEmpty()) {
            output.add(-1);
        }
        return output;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 3};
        List<Integer> duplicates = findDuplicatesUsingIncrementByNWay2(nums, nums.length);
        System.out.println(duplicates);
    }

}
