package challenges.assorted.misc;


/**
 * A program to check if a number is prime using loops.
 * <p>
 * Purpose of this class is to show basic iteration
 */
public class CheckPrime {

    public static boolean isPrimeUsingForLoop(int number) {
        for (int divisor = 2; divisor < number; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeUsingWhileLoop(int number) {
        int divisor = 2;
        while (divisor < number) {
            if (number % divisor == 0) {
                return false;
            }
            divisor++;
        }
        return true;
    }
}
