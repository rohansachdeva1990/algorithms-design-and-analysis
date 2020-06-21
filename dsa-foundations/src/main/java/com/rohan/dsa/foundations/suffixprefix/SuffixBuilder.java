package com.rohan.dsa.foundations.suffixprefix;

/**
 * Using String and StringBuilder
 */
public class SuffixBuilder {

    public static String[] suffixes(String s) {
        int N = s.length();
        String[] suffixes = new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = s.substring(i, N); // O(1)
        }

        return suffixes;
    }

    public static String[] suffixesUsingStringBuilder(String s) {
        int N = s.length();
        StringBuilder sb = new StringBuilder(s);
        String[] suffixes = new String[N];
        for (int i = 0; i < N; i++) {
            suffixes[i] = sb.substring(i, N); // O(N)
        }
        return suffixes;
    }
}
