package com.rohan.dsa.foundations.string;

/**
 * Rabin Karp algorith for substring matching.
 * <p>
 * In this method, we will use hashing technique and instead of checking for each possible
 * position in text, we only check if the hashing of pattern and the hashing og m characters
 * of text give the same result
 * <p>
 * Time complexity in worst case O(n^2)(depends on hash function)
 * Space complexity O(1)
 * <p>
 * References
 * https://en.wikipedia.org/wiki/Rabin%E2%80%93Karp_algorithm
 */
public class RabinKarpSubStringSearch {

    private final int PRIME = 101;

    public int search(String text, String pattern) {
        return search(text.toCharArray(), pattern.toCharArray());
    }

    private int search(char[] text, char[] pattern) {
        int textLength = text.length;
        int patternLength = pattern.length;

        long patternHash = hash(pattern, patternLength - 1);
        long textHash = hash(text, patternLength - 1);

        for (int i = 1; i <= textLength - patternLength - 1; i++) {
            if (patternHash == textHash &&
                    isEqual(text, i - 1, i + patternLength - 2, pattern, 0, patternLength - 1)) {
                return i - 1;
            }

            if (i < textLength - patternLength - 1) {
                textHash = rehash(text, i - 1, i + patternLength - 1, textHash, patternLength);
            }
        }
        return -1;
    }

    private long hash(char[] str, int end) {
        long hash = 0;
        for (int i = 0; i <= end; i++) {
            hash += str[i] * Math.pow(PRIME, i);
        }
        return hash;
    }

    private boolean isEqual(char str1[], int start1, int end1,
                            char str2[], int start2, int end2) {

        if (end1 - start1 != end2 - start2) {
            return false;
        }

        while (start1 <= end1 && start2 <= end2) {
            if (str1[start1] != str2[start2]) {
                return false;
            }
            start1++;
            start2++;
        }
        return true;
    }

    // Rolling hash
    private long rehash(char[] str, int oldIndex, int newIndex, long oldHash, int patternLen) {
        long newHash = oldHash - str[oldIndex];
        newHash = newHash / PRIME;
        newHash += str[newIndex] * Math.pow(PRIME, patternLen - 1);
        return newHash;
    }

    public static void main(String[] args) {
        RabinKarpSubStringSearch rks = new RabinKarpSubStringSearch();

        System.out.println(rks.search("RohanSachdeva", "hanSac"));
        System.out.println(rks.search("RohanSachdeva", "roh"));
        System.out.println(rks.search("RohanSachdeva", "nSach"));
        System.out.println(rks.search("RohanSachdeva", "deva"));
        System.out.println(rks.search("RohanSachdeva", "ohan"));
        System.out.println(rks.search("RohanSachdeva", "Rohan"));
    }
}
