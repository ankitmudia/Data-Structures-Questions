package BinarySearch;

public class BinarySearchPractice {

    static int findFirstPositionOfElement(int[] arr, int n, int x) {
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
            } else if (arr[mid] > x) {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }

    static int findLastPositionOfElement(int[] arr, int n, int x) {
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
            } else if (arr[mid] > x) {
                e = mid - 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }

    static int peakElement(int[] arr, int n) {
        int s = 0;
        int e = n - 1;
        int mid = s + (e - s) / 2;

        while (s < e) {
            System.out.println(mid+" aa");
            if (arr[mid] < arr[mid + 1]) {
                s = mid + 1;
            } else {
                e = mid;
            }
            mid = s + (e - s) / 2;
        }
        return s;
    }

    static int findPivot(int[] arr, int n) {
        int pivot = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                pivot = i + 1;
            }
        }
        return pivot;
    }

    static int binarySearch(int[] arr, int n, int x, int start, int end) {
        int s = start;
        int e = end;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                e = mid - 1;
            } else if (arr[mid] < x) {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }
        return -1;
    }

    static int findSqaureRoot(int n) {
        int s = 0;
        int e = n - 1;
        int mid = s + (e - s) / 2;

        while (s <= e) {
            if (mid * mid == n) {
                return mid;
            } else if (mid * mid > n) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 5, 5, 6, 6, 6 };
        // First Position of an element in sorted array
        System.out.println(findFirstPositionOfElement(arr, arr.length, 5));

        // Last position of an element in sorted array
        System.out.println(findLastPositionOfElement(arr, arr.length, 5));

        // total number of occurences of an element in sorted array
        System.out.println(
                findLastPositionOfElement(arr, arr.length, 5) - findFirstPositionOfElement(arr, arr.length, 5) + 1);

        // Find Peak element in mountain array
        int[] mountainArr = { 0, 10, 5, 2, 1 };
        System.out.println(peakElement(mountainArr, mountainArr.length));

        // Find pivot element in a rotated sorted array
        int[] rotatedSortedArr = { 8, 10, 17, 1, 3 };
        System.out.println(findPivot(rotatedSortedArr, rotatedSortedArr.length));

        // Search in Rotated Sorted array
        // int[] arr2 = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        // int key = 10;

        // int p = findPivot(arr2, arr2.length);
        // if (key >= arr[p] && key <= arr[arr2.length - 1]) {
        // System.out.println(binarySearch(arr2, arr2.length, key, p, arr2.length - 1));
        // } else {
        // System.out.println(binarySearch(arr2, arr2.length, key, 0, p - 1));
        // }

        // sqaure root using binary search
        int numberToFindSqaureOf = 36;
        System.out.println("Square Root Is: " + findSqaureRoot(numberToFindSqaureOf));
    }
}
