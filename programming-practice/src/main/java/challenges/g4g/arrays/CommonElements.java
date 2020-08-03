package challenges.g4g.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given three increasingly sorted arrays A, B, C of sizes N1, N2, and N3 respectively, you need to print all common elements in these arrays.
 * <p>
 * Note: Please avoid printing the same common element more than once.
 * <p>
 * Input:
 * First line contains a single integer T denoting the total number of test cases. T testcases follow. Each testcase contains four lines of input. First line consists of 3 integers N1, N2 and N3, denoting the sizes of arrays A, B, C respectively. The second line contains N1 elements of A array. The third lines contains N2 elements of B array. The fourth lines contains N3 elements of C array.
 * <p>
 * Output:
 * For each testcase, print the common elements of array. If not possible then print -1.
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N1, N2, N3 <= 107
 * 1 <= Ai, Bi, Ci <= 1018
 * <p>
 * Example:
 * Input:
 * 1
 * 6 5 8
 * 1 5 10 20 40 80
 * 6 7 20 80 100
 * 3 4 15 20 30 70 80 120
 * Output:
 * 20 80
 * <p>
 * Explanation:
 * Testcase1:  20 and 80 are the only common elements
 */
public class CommonElements {

    private List<Integer> findCommon(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> commonElements = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k] && arr3[k] == arr1[i]) {
                commonElements.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
        return commonElements;
    }

    public static void main(String[] args) {
        CommonElements ob = new CommonElements();

        int[] arr1 = {1, 5, 10, 20, 40, 80};
        int[] arr2 = {6, 7, 20, 80, 100};
        int[] arr3 = {3, 4, 15, 20, 30, 70, 80, 120};

        System.out.print("Common elements are ");
        List<Integer> commonElements = ob.findCommon(arr1, arr2, arr3);
        System.out.println(commonElements);
    }

}
