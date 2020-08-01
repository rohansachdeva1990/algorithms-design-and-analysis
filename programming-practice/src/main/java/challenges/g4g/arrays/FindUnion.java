package challenges.g4g.arrays;

/**
 * Given two sorted arrays, find their union
 * <p>
 * Example:-
 * Input : arr1[] = {1, 3, 4, 5, 7}
 * arr2[] = {2, 3, 5, 6}
 * Output : Union : {1, 2, 3, 4, 5, 6, 7}
 * Intersection : {3, 5}
 */
public class FindUnion {

    public int[] union(int[] arr1, int[] arr2) {
        int[] unionArr = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]) {
                unionArr[k] = arr1[i];
                i++;
            } else if (arr2[j] < arr1[i]) {
                unionArr[k] = arr2[j];
                j++;
            } else {
                unionArr[k] = arr1[i];
                i++;
            }
            k++;
        }

        while (i < arr1.length) {
            unionArr[k] = arr1[i];
            k++;
            i++;
        }


        while (j < arr2.length) {
            unionArr[k] = arr2[j];
            k++;
            j++;
        }

        return unionArr;
    }

    public static void unionWithDuplicates(int[] arr1, int[] arr2) {
        int m = arr1[arr1.length - 1];
        int n = arr2[arr2.length - 1];

        int size = Math.max(m, n);
        int[] table = new int[size + 1];

        table[arr1[0]]++;
        System.out.print(arr1[0] + " ");

        for (int i = 1; i < arr1.length; i++) {

            if (arr1[i] != arr1[i - 1]) {
                System.out.print(arr1[i] + " ");
                table[arr1[i]]++;
            }
        }

        for (int j = 0; j < arr2.length; j++) {
            if (table[arr2[j]] == 0) {
                System.out.print(arr2[j] + " ");
                table[arr2[j]]++;
            }

        }
    }

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 2, 2, 3};
        int[] arr2 = {2, 3, 4, 5};

        unionWithDuplicates(arr1, arr2);
    }
}
