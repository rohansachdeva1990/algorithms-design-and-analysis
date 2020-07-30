package challenges.assorted.ctci.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Category: Arrays & Strings
 * <p>
 * Implement an algorithm to determine if a string has all unique characters.
 * <p>
 * What if you cannot use additional data structures
 */
public class IsUnique {

    public static boolean isUniqueUsingDataStructure(String str) {
        Map<Character, Object> seenMap = new HashMap<>();
        final Object seenOnce = new Object();
        final Object seenMultiple = new Object();

        char[] arr = str.toCharArray();
        int length = arr.length;

        // Create a table contain seen once or more states
        for (char ch : arr) {
            if (!seenMap.containsKey(ch)) {
                seenMap.put(ch, seenOnce);
            } else {
                Object seen = seenMap.get(ch);
                if (!seen.equals(seenMultiple)) {
                    seenMap.put(ch, seenMultiple);
                }
            }
        }

        // Now scan the string chars to test the uniqueness
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (seenMap.get(ch).equals(seenMultiple)) {
                return false;
            }
        }
        return true;
    }

    // Assuming ASCII
    public static boolean isUniqueUsingFrequencyCounter(String str) {
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (charSet[ch]) {
                return false;
            }
            charSet[ch] = true;
        }
        return true;
    }

    public static boolean isUniqueEfficient(String str) {
        int checker = 0;
        int val = 0;
        for (int i = 0; i < str.length(); i++) {
            val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= 1 << val;
        }

        return true;
    }
}
