package com.rohan.dsa.foundations.string;

/**
 * Knuth-Morris-Pratt Algorithm.
 * <p>
 * It takes O(n) time complexity for searching a pattern. To get O(n) time complexity,
 * it avoids the comparisons with elements of text T that were previously involved in
 * comparison with some element of patter P.
 * <p>
 * We use a LPS (Longest Prefix Suffix) table or Pi table wherein the idea is to check
 * if in the pattern there exist any prefix same as suffix.
 * <p>
 * Runtime complexity - O(m + n) where m is length of text and n is length of pattern
 * Space complexity - O(n)
 */
public class KMPAlgorithm {

    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     * <p>
     * Eg. a, b, a, b, c -> 0 0 1 2 0
     */
    private int[] createLpsTable(char[] pattern) {
        int[] lps = new int[pattern.length];
        int j = 0;
        int i = 1;
        lps[0] = 0;
        
        while (i < pattern.length) {
            if (pattern[i] == pattern[j]) {
                lps[i] = j + 1;
                j++;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public int search(String text, String pattern) {
        return search(text.toCharArray(), pattern.toCharArray());
    }

    private int search(char[] text, char[] pattern) {
        int[] lps = createLpsTable(pattern);
        int i = 0;
        int j = 0;

        while (i < text.length && j < pattern.length) {
            if (text[i] == pattern[j]) {
                i++;
                j++;
            } else {
                // If different character
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
            if (j == pattern.length) {
                // Means pattern found.
                return i - j;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        KMPAlgorithm kmpAlgorithm = new KMPAlgorithm();
        final String pattern = "ababd";
        final String text = "ababcabcabababda";
        final int[] lps = kmpAlgorithm.createLpsTable(pattern.toCharArray());
        for (int e : lps) {
            System.out.print(e + " ");
        }
        System.out.println();
        int index = kmpAlgorithm.search(text, pattern);
        System.out.println(
                String.format("Found at index: %d and the pattern is %s",
                        index,
                        text.substring(index, index + pattern.length()))
        );
    }
}
