package challenges.assorted.tpie.arrays;

import java.util.Arrays;
import java.util.Collections;

/**
 * Category: Arrays & Strings
 * <p>
 * Write a function that reverses the order of the words in a string. For
 * example, your function should transform the string “Do or do not, there is no
 * try.” to “try. no is there not, do or Do”. Assume that all words are space delimited
 * and treat punctuation the same as letters.
 */
public class WordReverser {
    private static final String SPACE_REGEX = " +";

    public String reverseWordsUsingCollections(String str) {
        String[] words = str.trim().split(SPACE_REGEX);
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    public String reverseWordsUsingStringBuilder(String str) {
        String[] words = str.trim().split(SPACE_REGEX);
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i > 0; i--) {
            sb.append(words[i]).append(" ");
        }
        sb.append(words[0]);
        return sb.toString();
    }

    // Preferred Way
    public String reverseWordsInplace(String str) {
        char[] arr = str.toCharArray();
        int start = 0;
        int end = 0;
        int length = arr.length;

        // Reverse entire string
        reverse(arr, start, length - 1);

        while (end < length) {
            //  Skip non-word characters
            if (arr[end] != ' ') {

                // Save position of beginning of word
                start = end;

                // Scan to next non-word character
                while (end < length && arr[end] != ' ')
                    end++;

                // Back up to end of word
                end--;

                // Reverse word
                reverse(arr, start, end);
            }
            // Advance to next token
            end++;
        }
        return new String(arr);
    }

    private void reverse(char[] arr, int start, int end) {
        char temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        WordReverser o = new WordReverser();
        final String result = o.reverseWordsInplace("abc def ghi");
        System.out.println(result);
    }
}
