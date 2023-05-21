/*
 * following a simple approach, 
 * will find product of the elements of array, 
 * result array will contain, remainder of product/arr[i], where arr is original array;
 */

public class ProductArray {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = { 10, 3, 5, 6, 2 };
        int[] result = new int[n];
        int product = 1;
        for (int i = 0; i < n; i++) {
            product *= arr[i];
        }
        for (int i = 0; i < n; i++) {
            result[i] = product / arr[i];
        }
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
