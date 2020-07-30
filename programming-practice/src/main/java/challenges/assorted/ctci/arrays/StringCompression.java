package challenges.assorted.ctci.arrays;

/**
 * Category: Arrays & Strings
 * <p>
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3.
 * <p>
 * If the "compressed" string would not become smaller than the original string, your method should return
 * the original string.
 * <p>
 * You can assume the string has only uppercase and lowercase letters (a - z).
 * <p>
 * Idea: count and append if different
 */
public class StringCompression {

    public static String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        int consecutiveCount = 0;
        for (int i = 0; i < str.length(); i++) {
            consecutiveCount++;
            if ((i + 1) >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i)).append(consecutiveCount);
                consecutiveCount = 0;
            }
        }

        return (compressed.length() < str.length()) ? compressed.toString() : str;
    }

    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println(String.format("Before compression: %s", str));
        System.out.println(String.format("After compression: %s", compress(str)));

        String str2 = "compressed";
        System.out.println(String.format("Before compression: %s", str2));
        System.out.println(String.format("After compression: %s", compress(str2)));
    }
}
