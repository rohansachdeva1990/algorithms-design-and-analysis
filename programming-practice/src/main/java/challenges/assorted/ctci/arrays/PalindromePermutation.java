package challenges.assorted.ctci.arrays;

/**
 * Category: Arrays & Strings
 * <p>
 * Palindrome Permutation: Given a string, write a function to check if it is a permutation
 * of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters. The palindrome does not need to be limited
 * to just dictionary words.
 * <p>
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco eta", etc.)
 */
public class PalindromePermutation {

    // Way 1
    public boolean isPalindromePermutationWay1(String str) {
        int[] table = buildFrequencyTable(str);
        return checkPermutation(table);
    }

    private int[] buildFrequencyTable(String str) {
        // This will cover both A and a.
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for (char ch : str.toCharArray()) {
            int chNum = getCharNumericValue(ch);
            if (getCharNumericValue(ch) != -1) {
                table[chNum]++;
            }
        }
        return table;
    }

    private int getCharNumericValue(char ch) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(ch);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    private boolean checkPermutation(int[] table) {
        boolean oddFound = false;
        for (int val : table) {
            if (val % 2 != 0) {
                if (oddFound) {
                    return false;
                }
                oddFound = true;
            }
        }
        return true;
    }

    // Way - 2 - Little better than before
    // Idea is to check the odd count while iterating
    public boolean isPalindromePermutationWay2(String str) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        int countOdd = 0;

        for (char ch : str.toCharArray()) {
            int chNumVal = getCharNumericValue(ch);

            // Ignore other characters
            if (chNumVal == -1) {
                continue;
            }

            table[chNumVal]++;
            if (table[chNumVal] % 2 != 0) {
                countOdd++;
            } else {
                countOdd--;
            }
        }

        // count of odd occurrence should be atmost 1
        return countOdd <= 1;
    }

    // Way - 3
    // Idea is to maintain a bit pattern and toggle the bits
    private boolean isPalindromePermutationWay3(String str) {
        int bitPattern = createBitPattern(str);
        return checkPermutation(bitPattern);
    }

    private boolean checkPermutation(int bitPattern) {
        return (bitPattern & (bitPattern - 1)) == 0;
    }

    private int createBitPattern(String str) {
        int bitPattern = 0;
        for (char ch : str.toCharArray()) {
            int val = getCharNumericValue(ch);
            if (val != -1) {
                bitPattern = toggleBit(bitPattern, val);
            }
        }
        return bitPattern;
    }

    private int toggleBit(int bitPattern, int index) {
        int mask = 1 << index;
        if ((bitPattern & mask) == 0) {
            bitPattern |= mask;
        } else {
            bitPattern &= ~mask;
        }
        return bitPattern;
    }

    public static void main(String[] args) {
        PalindromePermutation palindromePermutation = new PalindromePermutation();
        System.out.println(palindromePermutation.isPalindromePermutationWay1("tacocat"));
        System.out.println(palindromePermutation.isPalindromePermutationWay2("tacocat"));
        System.out.println(palindromePermutation.isPalindromePermutationWay3("tacocat"));
    }
}
