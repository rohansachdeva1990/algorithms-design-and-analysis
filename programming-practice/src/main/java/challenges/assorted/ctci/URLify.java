package challenges.assorted.ctci;

import java.util.Arrays;

/**
 * Category: Arrays & Strings
 * <p>
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string
 * has sufficient space at the end to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: if implementing in Java, please use a character array so that you can
 * perform this operation in place.)
 * <p>
 * EXAMPLE
 * Input: "Mr John Smith", 13
 * Output: "Mr%20John%20Smith"
 */
public class URLify {

    public void replaceSpaces(char[] str, int trueLength) {

        // Count the total spaces in the string
        int totalSpaces = 0;

        // We should count spaces till true length
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                totalSpaces++;
            }
        }

        // The "2" comes from size of "%20" - 1(which is space)
        int index = trueLength + (totalSpaces * 2);

        // if there are trailing spaces in the string
        if (trueLength < str.length) {
            str[trueLength] = '\0';
        }

        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static void main(String[] args) {
        String str = "Mr John Smith";
        char[] arr = str.toCharArray();
        final char[] newArr = Arrays.copyOfRange(arr, 0, 32);
        new URLify().replaceSpaces(newArr, 13);
        System.out.println(new String(arr));
    }
}
