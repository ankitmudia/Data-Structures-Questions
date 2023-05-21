package slidingWindow;

public class maximumSubarraySizeK {

    static int solve(int[] arr, int n, int k) {
        int i = 0;
        int j = 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        while (j < n) {
            sum += arr[j];
            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                // update the sum to use further
                sum = sum - arr[i];
                i++;
                j++;
            } else {
                j++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 10, 23, 3, 1, 0, 20 };
        int n = arr.length;
        int k = 4;
        System.out.println(solve(arr, n, k));
    }
}
