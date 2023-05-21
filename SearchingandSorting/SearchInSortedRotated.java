/*
 * first we find pivot element, then we will use pivot element for our
 * start and end in binary search, to reduce our search space
 */
public class SearchInSortedRotated {
    // finding the pivot element through linear searching
    static int findPivot(int[] arr, int n) {
        int ans = -1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                ans = i + 1;
            }
        }
        return ans;
    }

    static int binarySearch(int[] arr, int s, int e, int target) {
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (arr[mid] == target) {
                return mid;
            }
            if (target > arr[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        int n = 9;
        int target = 10;
        int pivot = findPivot(arr, n);
        if ((arr[pivot] <= target) && (target <= arr[n - 1])) {
            System.out.println(binarySearch(arr, pivot, n - 1, target));
        } else {
            System.out.println(binarySearch(arr, 0, pivot - 1, target));
        }
    }
}
