package challenges.g4g.arrays;

/**
 * Find intersection of 2 sorted arrays.
 * <p>
 * arr1[] = {2, 5, 6}
 * arr2[] = {4, 6, 8, 10}
 * Intersection : {6}
 */
public class FindIntersection {

    public static void printIntersection(int[] arr1, int[] arr2) {

        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};

        printIntersection(arr1, arr2);
    }
}
