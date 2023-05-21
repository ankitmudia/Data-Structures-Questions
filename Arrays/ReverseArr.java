/**
 * Reverse
 */

/**
 * algo - two pointer approach
 * - we will take one pointer s on 0th index and one pointer e on last index
 * - will swap elements using temporary variable and will increment s and will
 * decrement e by 1
 * - while s<e;
 */

public class ReverseArr {

    static void solve(int[] arr, int n) {
        int s = 0;
        int e = n - 1;
        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }

    static void print(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int n = arr.length;
        print(arr, n);
        solve(arr, n);
        print(arr, n);
    }
}