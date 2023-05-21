/**
 * FirstAndLastOcc -
 * using binary search to find first and last occurences
 * find the middle element, check if x > mid or x < mid
 * if greater, go to right part and search
 * if smaller, go to left part ans search,
 * catch, if mid == x, store the index and for first index e = mid - 1;
 * and for last index s = mid + 1;
 */
public class FirstAndLastOcc {

    static int findFirstOcc(int[] arr, int n, int x) {
        int s = 0;
        int e = n - 1;
        int mid = s + (e - s) / 2;
        int ans = -1;
        while (s <= e) {
            if (arr[mid] == x) {
                ans = mid;
                e = mid - 1;
            } else if (arr[mid] < x) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }

    static int findLastOcc(int[] arr, int n, int x) {
        int s = 0;
        int e = n - 1;
        int mid = s + (e - s) / 2;
        int ans = -1;
        while (s <= e) {
            if (arr[mid] == x) {
                ans = mid;
                s = mid + 1;
            } else if (arr[mid] < x) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
        int n = 9;
        int first = findFirstOcc(arr, n, 5);
        int last = findLastOcc(arr, n, 5);
        System.out.println(first);
        System.out.println(last);
    }
}