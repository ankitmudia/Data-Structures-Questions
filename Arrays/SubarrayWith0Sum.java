public class SubarrayWith0Sum {
    static int solve(int[] arr, int n) {
        int largest = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == 0) {
                    largest = Math.max(largest, j - i + 1);
                }
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
        int n = arr.length;

        // brute force
        int bruteForce = solve(arr, n);
        System.out.println(bruteForce);
    }
}
