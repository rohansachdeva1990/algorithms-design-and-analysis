package challenges.assorted.ctci;

/**
 * Category: Arrays & Strings
 * <p>
 * Assume you have a method isSubstring which checks if one word is a substring
 * of another. Given two strings, sl and s2, write code to check if s2 is a rotation
 * of sl using only one call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
 */
public class StringRotation {

    public boolean isStringRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String s1s2 = s1 + s2;
        return isSubstring(s1s2, s2);
    }

    private boolean isSubstring(String s1s2, String s2) {
        return s1s2.contains(s2);
    }

    public static void main(String[] args) {
        StringRotation stringRotation = new StringRotation();
        System.out.println(stringRotation.isStringRotation("waterbottle", "erbottlewat"));
    }
}
