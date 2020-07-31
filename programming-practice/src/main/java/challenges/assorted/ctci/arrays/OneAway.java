package challenges.assorted.ctci.arrays;

/**
 * Category: Arrays & Strings
 * <p>
 * There are three types of edits that can be performed on strings: insert a character,
 * remove a character, or replace a character. Given two strings, write a function to check if they are
 * one edit (or zero edits) away.
 * <p>
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
public class OneAway {

    public static boolean isOneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return isOneReplaceAway(first, second);
        } else if (first.length() + 1 == second.length()) {
            return isOneInsertAway(first, second);
        } else if (first.length() - 1 == second.length()) {
            return isOneInsertAway(second, first);
        }
        return false;
    }

    private static boolean isOneReplaceAway(String first, String second) {
        int length = first.length();
        int i = 0;
        boolean foundDifferent = false;
        while (i < length) {
            if (first.charAt(i) != second.charAt(i)) {
                if (foundDifferent) {
                    return false;
                }
                foundDifferent = true;
            }
            i++;
        }
        return true;
    }

    private static boolean isOneInsertAway(String shortStr, String longStr) {
        int shortPtr = 0;
        int longPtr = 0;
        while (shortPtr < shortStr.length() && longPtr < longStr.length()) {
            if (shortStr.charAt(shortPtr) != longStr.charAt(longPtr)) {
                if (shortPtr != longPtr) {
                    return false;
                }
                longPtr++;
            } else {
                longPtr++;
                shortPtr++;
            }
        }
        return true;
    }

    public static boolean isOneEditAway2(String first, String second) {

        // If they have difference of length greater than 1, return false
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        String shortString = first.length() < second.length() ? first : second;
        String longString = first.length() < second.length() ? second : first;

        int shortPtr = 0;
        int longPtr = 0;
        boolean foundDifference = false;

        while (shortPtr < shortString.length() && longPtr < longString.length()) {
            if (shortString.charAt(shortPtr) != longString.charAt(longPtr)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;

                // On replace move shorter pointer
                if (shortString.length() == longString.length()) {
                    shortPtr++;
                }
            } else {
                // if matching move shorter pointer
                shortPtr++;
            }

            // Move longer pointer always
            longPtr++;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(isOneEditAway("pale", "ple"));
        System.out.println(isOneEditAway("pales", "pale"));
        System.out.println(isOneEditAway("pale", "bale"));
        System.out.println(isOneEditAway("pale", "bake"));

        System.out.println(isOneEditAway2("pale", "ple"));
        System.out.println(isOneEditAway2("pales", "pale"));
        System.out.println(isOneEditAway2("pale", "bale"));
        System.out.println(isOneEditAway2("pale", "bake"));
    }
}
