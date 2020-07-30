package challenges.assorted.ctci.arrays;

import java.util.Arrays;

/**
 * Category: Arrays & Strings
 * <p>
 * Given two strings, write a method to decide if one is a permutation of the
 * other.
 */
public class CheckPermutation {

    public boolean checkPermutationUsingSorting(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        String sortedS1 = sort(s1);
        String sortedS2 = sort(s2);
        return sortedS1.equals(sortedS2);
    }

    private static String sort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    // Again with the help of frequency counter
    public boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        final int[] letters = new int[128];
        for (char ch : s1.toCharArray()) {
            letters[ch]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            letters[ch]--;
            if (letters[ch] < 0) {
                return false;
            }
        }

        return true;
    }
}
