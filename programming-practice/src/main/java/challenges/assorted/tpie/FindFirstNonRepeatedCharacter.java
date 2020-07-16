package challenges.assorted.tpie;

import java.util.HashMap;
import java.util.Map;

/**
 * Category: Arrays & Strings
 * <p>
 * An efficient function to find the first nonrepeated character
 * in a string.
 * <p>
 * For instance, the first nonrepeated character in “total” is ‘o’ and
 * the first nonrepeated character in “teeter” is ‘r’.
 * <p>
 * Naive Approach:-
 * 1. Compare each character by all characters in the string and check if
 * that character has occurred more than once - O(n^2)
 * 2. Compare each character as above but, only in forward direction - O(n^2)
 * <p>
 * Best Approach:-
 * Need to put this text in some data structure for faster retrieval. So, something
 * like a frequency table where the index value is a character. By this we can directly
 * jump at particular index of corresp. text char.
 * <p>
 * Use Arrays: When long strings and limited character sets (ASCII) - O(1)
 * Use Hashtable: When short strings and many possible character set (UNICODE) - O(logn)
 * <p>
 * Algorithm:
 * 1. Build the character count table
 * 2. Scan each character of the string in character count
 * table until you get the first single occurrence
 */
public class FindFirstNonRepeatedCharacter {

    public static Character firstNonRepeatedCharacter(String str) {

        // Build character count table
        Map<Character, Integer> freqTable = new HashMap<>();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (!freqTable.containsKey(c)) {
                freqTable.put(c, 1);
            } else {
                freqTable.put(c, freqTable.get(c) + 1);
            }
        }

        // Now scan remaining
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (freqTable.get(c) == 1) {
                return c;
            }
        }
        return null;
    }

    /**
     * We can avoid creating unnecessary Integer objects, when incrementing the counters
     * in the maps
     */
    public static Character firstNonRepeatedCharacterImproved(String str) {

        Map<Character, Object> charSeenMap = new HashMap<>();
        final Object seenOnce = new Object();
        final Object seenMoreThanOnce = new Object();

        int length = str.length();

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);

            if (!charSeenMap.containsKey(c)) {
                charSeenMap.put(c, seenOnce);
            } else {
                final Object seen = charSeenMap.get(c);
                if (seen.equals(seenOnce)) {
                    charSeenMap.put(c, seenMoreThanOnce);
                }
            }
        }

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (charSeenMap.get(c).equals(seenOnce)) {
                return c;
            }
        }


        return null;
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatedCharacter("total"));
        System.out.println(firstNonRepeatedCharacterImproved("teeter"));
    }

}
