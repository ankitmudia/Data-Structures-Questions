package BinarySearch;

public class BookAllocation {
    static boolean isPossible(int[] arr, int n, int student, int mid) {
        int studentCount = 1;
        int pageSum = 0;

        for (int i = 0; i < n; i++) {
            if (pageSum + arr[i] <= mid) {
                pageSum += arr[i];
            } else {
                studentCount++;
                if (studentCount > student || arr[i] > mid) {
                    return false;
                }
                pageSum = arr[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        int student = 2;
        int[] arr = { 12, 34, 67, 90 };
        int s = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int e = sum;
        int mid = s + (e - s) / 2;
        int ans = -1;
        while (s <= e) {
            if (isPossible(arr, n, student, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }
        System.out.println(ans);
    }

}
