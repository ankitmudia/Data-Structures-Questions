/*
 * optimised approach - 
 * take two variables, i and j, put i on last of arr1,
 * j on first of arr2, now check if arr1[i] > arr2[j], swap and i++, j--;
 * if(i == 0) && arr[i] < arr[j];
 * break;
 * else {
 * i--; j++;
 * }
 * 
 * sort both the arrays and return them
 */

import java.util.Arrays;

public class MergeWithoutExtraSpace {
    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7 };
        int n = 4;
        int[] arr2 = { 0, 2, 6, 8, 9 };
        int m = 5;

        int i = n - 1;
        int j = 0;
        while (i >= 0 && j < m) {
            if (arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i++;
                j--;
            }
            if (i == 0 && arr1[i] < arr2[j]) {
                break;
            } else {
                i--;
                j++;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int k = 0; k < n; k++) {
            System.out.print(arr1[k] + " ");
        }
        for (int k = 0; k < m; k++) {
            System.out.print(arr2[k] + " ");
        }
    }
}
