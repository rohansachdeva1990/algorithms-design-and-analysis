package challenges.g4g.arrays;


import java.util.Arrays;

/**
 * Rearrange array in alternating positive & negative items with O(1)
 * <p>
 * Given an array of positive and negative numbers, arrange them in an alternate fashion such
 * that every positive number is followed by negative and vice-versa maintaining the order of appearance.
 * Number of positive and negative numbers need not be equal. If there are more positive numbers they
 * appear at the end of the array. If there are more negative numbers, they too appear in the end of the array.
 * <p>
 * Example:-
 * <p>
 * Input:  arr[] = {1, 2, 3, -4, -1, 4}
 * Output: arr[] = {-4, 1, -1, 2, 3, 4}
 * <p>
 * Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
 * output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}
 * <p>
 * <p>
 * Optimal Approach:-
 * 1. Follow quick sort approach by taking 0 as pivot
 * 2. Partition the array around the pivot
 * 3. Now negative elements will be on left and positive on the right
 * 4. Take 2 index, negative = 0 and positive = partitionIndex
 * 5. Increment negative by 2 and positive by 1
 */
public class AlternatePositiveNegative {

    public void rearrangeWithNegativesOnOddPosition(int[] arr) {
        rearrange(arr, 1);
    }

    public void rearrangeWithNegativesOnEvenPosition(int[] arr) {
        rearrange(arr, 0);
    }

    private void rearrange(int[] arr, int negStart) {
        int pos = partition(arr); // This will be first positive number in the array
        System.out.println("After Partition: " + Arrays.toString(arr));
        for (int neg = negStart; pos < arr.length && neg < pos; pos++, neg += 2) {

            if (arr[neg] >= 0) {
                return;
            }

            int temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
        }
    }

    private int partition(int[] arr) {
        int pivot = 0;
        int pIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;

            }
        }

        return pIndex;
    }

    public static void main(String[] args) {
        AlternatePositiveNegative alternatePositiveNegative = new AlternatePositiveNegative();
        int[] arr1 = {9, -3, 5, -2, -8, -6, 1, 3};
        int[] arr2 = {9, -3, 5, -2, -8, -6, 1, 3};

        System.out.println("Before: " + Arrays.toString(arr1));
        alternatePositiveNegative.rearrangeWithNegativesOnOddPosition(arr1);
        System.out.println("After: " + Arrays.toString(arr1));

        System.out.println("Before: " + Arrays.toString(arr2));
        alternatePositiveNegative.rearrangeWithNegativesOnEvenPosition(arr2);
        System.out.println("After: " + Arrays.toString(arr2));
    }

}
