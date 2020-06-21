package com.rohan.dsa.foundations.string;

/**
 * An algorithm that is capable of finding a pattern in a text
 * <p>
 * - This is a brute force or naive approach
 * - Keep iterating through the text and if there is a mismatch we shift the pattern
 * one step to right
 * - Not so efficient especially when there are lots of matching prefixes
 * - For eg. pattern is DDDDDE and the text is DDDDDDDDDDE
 * - Main problem: needs backup for every mismatch.. if there is a mismatch we jump
 * back to the next character
 * - Lots of compares: ~ N*M where N is the length of the text, M is the length of
 * the pattern we are looking for.
 * - Imagine it like a sliding window
 */
public class BruteForcePatternSearch {

    public static int search(String text, String pattern) {

        int textLength = text.length();
        int patternLength = pattern.length();

        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;
            for (j = 0; j < patternLength; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == patternLength) {
                return i;
            }
        }
        return -1;
    }

}
