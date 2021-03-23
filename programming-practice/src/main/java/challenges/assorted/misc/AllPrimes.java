package challenges.assorted.misc;

import utilities.ConversionHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Prints all prime number in range (2...N)
 * <p>
 * Purpose of this function is show "Loop bounds"
 */
public class AllPrimes {

    private final static ConversionHelper CONVERSION_HELPER = ConversionHelper.INSTANCE;

    /**
     * Using Sieve Of Eratosthenes
     *
     * @param number
     * @return
     */
    public static int[] getPrimeNumbersFast(int number) {

        // number + 1, because it might be possible that the last number
        // is a prime number. Only because index starts from 0.
        boolean[] primes = new boolean[number + 1];

        // Assumption, mark every number is prime
        for (int i = 0; i <= number; i++) {
            primes[i] = true;
        }

        for (int divisor = 2; (divisor * divisor) <= number; divisor++) {
            // Start marking multiple of divisor to false
            if (primes[divisor]) {
                for (int i = 2 * divisor; i <= number; i = i + divisor) {
                    primes[i] = false;
                }
            }
        }

        // Print
        List<Integer> primeList = new ArrayList<>();
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                primeList.add(i);
            }
        }
        return CONVERSION_HELPER.fromIntegerListToIntegerArray(primeList);
    }

    /**
     * Print all prime numbers.
     *
     * @param number Number till we want to print prime number
     * @return primes till number
     */
    public static int[] getPrimeNumbersSlow(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative number not allowed!");
        }
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = 0; i <= number; i++) {
            if (CheckPrime.isPrimeUsingForLoop(i)) {
                primeNumbers.add(i);
            }
        }
        return CONVERSION_HELPER.fromIntegerListToIntegerArray(primeNumbers);
    }
}
