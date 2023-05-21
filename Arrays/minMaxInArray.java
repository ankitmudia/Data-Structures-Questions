/**
 * minMaxInArray
 */
/**
 * - checking and swapping with the next element if found minimum or maximum
 */
public class minMaxInArray {

    static int solveMax(int[] arr, int n) {
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static int solveMin(int[] arr, int n) {
        int min = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int n = arr.length;
        System.out.println("Max is: " + solveMax(arr, n));
        System.out.println("Min is: " + solveMin(arr, n));
    }
}
