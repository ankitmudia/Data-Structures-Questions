package slidingWindow;

public class SubarrayWithSumGreaterThanX {
    static int solve(int[] arr, int x, int n) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        while (j < n) {
            sum += arr[j];
            if (sum > x) {
                answer = Math.min(answer, j - i + 1);
                while (sum - arr[i] > x) {
                    sum -= arr[i];
                    i++;
                    answer = Math.min(answer, j - i + 1);
                }
            }
            j++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 5, 2, 7};
        int x = 9;
        int n = arr.length;
        System.out.println(solve(arr, x, n));

    }
}
