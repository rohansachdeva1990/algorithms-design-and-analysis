package challenges.assorted.tpie;

import java.util.HashSet;
import java.util.Set;

/**
 * Category: Arrays & Strings
 * <p>
 * An efficient function that deletes characters from a mutable
 * ASCII string. Your function should take two arguments, str and remove. Any
 * character existing in remove must be deleted from str.
 * <p>
 * For example, given a str of "Battle of the Vowels: Hawaii vs. Grozny" and a remove of
 * "aeiou", the function should transform str to "Bttl f th Vwls: Hw vs. Grzny".
 * <p>
 * Algorithm:-
 * 1. Iterate through each character in remove, setting the corresponding value in the lookup array
 * to true.
 * 2. Iterate through str with a source and destination index, copying each character only if its
 * corresponding value in the lookup array is false.
 * 3. Set the length of str to account for the characters that have been removed
 */
public class RemoveSpecifiedCharacters {

    // Naive Way
    public static String removeChars(String str, String remove) {
        Set<Character> removeSet = new HashSet<>();
        for (int i = 0; i < remove.length(); i++) {
            removeSet.add(remove.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            final char c = str.charAt(i);
            if (!removeSet.contains(c)) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void removeChars(StringBuilder str, String remove) {
        // Create a lookup for ASCII
        boolean[] removeLookup = new boolean[128];

        // Populate it
        for (char ch : remove.toCharArray()) {
            removeLookup[ch] = true;
        }

        // Now update the existing string using src and dest pointers
        int dest = 0;
        int strLen = str.length();
        for (int src = 0; src < strLen; ++src) {
            char ch = str.charAt(src);
            // If char not to be removed, then add it
            if (!removeLookup[ch]) {
                str.setCharAt(dest++, ch);
            }
        }
        // Truncate
        str.setLength(dest);
    }


    public static void main(String[] args) {
        String str = "Battle of the Vowels: Hawaii vs. Grozny";
        String removeStr = "aeiou";
        System.out.println(removeChars(str, removeStr));

        StringBuilder sb = new StringBuilder(str);
        removeChars(sb, removeStr);
        System.out.println(sb.toString());
    }
}
