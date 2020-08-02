package challenges.g4g.arrays;

import java.util.AbstractMap.SimpleEntry;
import java.util.*;

/**
 * Given an array of integers, and an integer  ‘K’ , find the count of pairs of elements in the array whose sum is equal to 'K'.
 * <p>
 * Input:
 * First line of the input contains an integer T, denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains 2 space separated integers N and K denoting the size of array and the sum respectively. Second line of each test case contains N space separated integers denoting the elements of the array.
 * <p>
 * Output:
 * Print the count of pairs of elements in the array whose sum is equal to the K.
 * <p>
 * Constraints:
 * 1<=T<=50
 * 1<=N<=50
 * 1<=K<=50
 * 1<=A[i]<=100
 * <p>
 * Example:
 * Input
 * 2
 * 4 6
 * 1  5  7 1
 * 4 2
 * 1 1 1 1
 * Output
 * 2
 * 6
 * <p>
 * Approach:-
 * 1. Naive way using 2 loops
 * 2. Sort the array and use binary search to find pairs
 * 3. Using Map or Set.
 */
public class CountPairsWithGivenSum {

    /**
     * A simple solution is be traverse each element and check if there’s another
     * number in the array which can be added to it to give sum.
     * <p>
     * O(n^2)
     */
    public static List<SimpleEntry<Integer, Integer>> findPairsNaiveWay(int[] arr, int sum) {
        List<SimpleEntry<Integer, Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    pairs.add(new SimpleEntry<>(arr[i], arr[j]));
                }
            }
        }
        return pairs;
    }


    /**
     * Idea is to sort the array in ascending order and maintain search space by maintaining two indices
     * (beg and end) that initially points to two-endpoints of the array. Then we loop till beg is less than
     * end index and reduce search space [beg..end] at each iteration of the loop. We compare sum of elements
     * present at index beg and end with desired sum and increment be if sum is less than the desired sum
     * else we decrement end is sum is more than the desired sum
     * <p>
     * O(nlogn)
     */
    public static List<SimpleEntry<Integer, Integer>> findPairsUsingSorting(int[] arr, int sum) {
        List<SimpleEntry<Integer, Integer>> pairs = new ArrayList<>();

        Arrays.sort(arr);
        int beg = 0;
        int end = arr.length - 1;

        while (beg < end) {
            int elementSum = arr[beg] + arr[end];
            if (elementSum == sum) {
                pairs.add(new SimpleEntry<>(arr[beg], arr[end]));
                beg++;
                end--;
            } else if (elementSum < sum) {
                beg++;
            } else {
                end--;
            }
        }

        return pairs;
    }


    /**
     * We can use map to easily solve this problem in linear time. The idea is to insert each
     * element of the array arr[i] in a map. We also checks if dierence (arr[i], sumarr[i])
     * already exists in the map or not. If the dierence is seen before, we print the pair and return.
     * <p>
     * O(n)
     */
    public static List<SimpleEntry<Integer, Integer>> findPairsUsingHashing(int[] arr, int sum) {
        List<SimpleEntry<Integer, Integer>> pairs = new ArrayList<>();

        // Stores index
        Map<Integer, Integer> occurrence = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (occurrence.containsKey(sum - arr[i])) {
                pairs.add(new SimpleEntry<>(arr[i], arr[occurrence.get(sum - arr[i])]));
            }
            occurrence.put(arr[i], i);
        }

        return pairs;
    }

    public static void main(String[] args) {
        System.out.println("Using naive way");
        System.out.println(findPairsNaiveWay(new int[]{1, 5, 7, 1}, 6));
        System.out.println(findPairsNaiveWay(new int[]{1, 1, 1, 1}, 2).size());
        System.out.println(findPairsNaiveWay(new int[]{8, 7, 2, 5, 3, 1}, 10));

        System.out.println("Using sorting way");
        System.out.println(findPairsUsingSorting(new int[]{1, 5, 7, 1}, 6));
        System.out.println(findPairsUsingSorting(new int[]{1, 1, 1, 1}, 2).size());
        System.out.println(findPairsUsingSorting(new int[]{8, 7, 2, 5, 3, 1}, 10));


        System.out.println("Using hashing");
        System.out.println(findPairsUsingHashing(new int[]{1, 5, 7, 1}, 6));
        System.out.println(findPairsUsingHashing(new int[]{1, 1, 1, 1}, 2).size());
        System.out.println(findPairsUsingHashing(new int[]{8, 7, 2, 5, 3, 1}, 10));
    }
}
