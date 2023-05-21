package Recursion;

import java.util.ArrayList;

public class RecursionPractice {

    static int fibonacci(int n) {
        // base case
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int distinctWaysToClimbStairs(int n) {
        // base case
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        return distinctWaysToClimbStairs(n - 1) + distinctWaysToClimbStairs(n - 2);
    }

    static void sayDigit(int n, String[] arr) {
        // base case
        if (n == 0)
            return;

        // processing
        int digit = n % 10;
        n = n / 10;

        sayDigit(n, arr);
        System.out.print(arr[digit] + " ");
    }

    static boolean isSorted(int[] arr, int n) {
        // base case
        if (n == 0 || n == 1) {
            return true;
        }
        if (arr[n - 1] < arr[n - 2]) {
            return false;
        }
        boolean ans = isSorted(arr, n - 1);
        return ans;
    }

    static boolean linearSearch(int[] arr, int key, int n) {
        // base case
        if (n == 0) {
            return false;
        }
        if (arr[n - 1] == key) {
            return true;
        }

        return linearSearch(arr, key, n - 1);
    }

    static boolean binarySearch(int[] arr, int key, int n, int s, int e) {
        int mid = s + (e - s) / 2;

        // base case
        if (s > e) {
            return false;
        }
        if (arr[mid] == key) {
            return true;
        }

        if (arr[mid] > key) {
            return binarySearch(arr, key, n, s, mid - 1);
        } else {
            return binarySearch(arr, key, n, s + 1, e);
        }

    }

    static void reverseString(char[] str, int s, int e) {
        // base case
        if (s > e) {
            return;
        }

        char temp = str[s];
        str[s] = str[e];
        str[e] = temp;
        s++;
        e--;

        reverseString(str, s, e);

    }

    static void mergeTwoSortedArrays(int[] arr, int s, int e) {
        int mid = s + (e - s) / 2;

        int len1 = mid - s + 1;
        int len2 = e - mid;

        int[] arr1 = new int[len1];
        int[] arr2 = new int[len2];

        int k = s;
        for (int i = 0; i < len1; i++) {
            arr1[i] = arr[k++];
        }
        k = mid + 1;
        for (int i = 0; i < len2; i++) {
            arr2[i] = arr[k++];
        }

        int i1 = 0;
        int i2 = 0;
        int l = s;

        while (i1 < len1 && i2 < len2) {
            if (arr1[i1] < arr2[i2]) {
                arr[l++] = arr1[i1++];
            } else {
                arr[l++] = arr2[i2++];
            }
        }

        while (i1 < len1) {
            arr[l++] = arr1[i1++];
        }
        while (i2 < len2) {
            arr[l++] = arr2[i2++];
        }
    }

    static void mergeSort(int[] arr, int s, int e) {

        if (s >= e) {
            return;
        }

        int mid = s + (e - s) / 2;
        // sort left
        mergeSort(arr, s, mid);

        // sort right
        mergeSort(arr, mid + 1, e);

        mergeTwoSortedArrays(arr, s, e);
    }

    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int partition(int[] arr, int s, int e) {
        int pivot = arr[0];

        int count = 0;
        for (int i = s + 1; i <= e; i++) {
            if (arr[i] <= pivot) {
                count++;
            }
        }

        int pivotIndex = s + count;
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[s];
        arr[s] = temp;

        int i = s;
        int j = e;
        while (i < pivotIndex && j > pivotIndex) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < pivotIndex && j > pivotIndex) {
                int temp2 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp2;
                i++;
                j--;
            }
        }
        return pivotIndex;
    }

    static void quickSort(int[] arr, int s, int e) {
        if (s >= e) {
            return;
        }

        // partition
        int p = partition(arr, s, e);

        // sort left
        quickSort(arr, s, p - 1);

        // sort left
        quickSort(arr, p + 1, e);
    }

    static void solveSubset(int[] arr, int index, ArrayList<Integer> output,
            ArrayList<ArrayList<Integer>> al) {
        // base case
        if (index >= arr.length) {
            System.out.println(output);
            al.add(output);
            return;
        }
        // include
        output.add(arr[index]);
        solveSubset(arr, index + 1, output, al);

        // exclude
        output.remove(output.size() - 1);
        solveSubset(arr, index + 1, output, al);
    }

    public static void main(String[] args) {
        // Print nth Fibonacci number

        int fibAns = fibonacci(8);
        System.out.println(fibAns);

        // Distinct Ways to climb stairs

        int numberOfStairs = 2;
        int distinctWaysToClimbStairsAnswer = distinctWaysToClimbStairs(numberOfStairs);
        System.out.println(distinctWaysToClimbStairsAnswer);

        // Say Digit
        int sayDigitNumber = 412;
        String[] sayDigitArr = { "Zero", "One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine" };
        sayDigit(sayDigitNumber, sayDigitArr);
        System.out.println();

        // check if array is sorted
        int[] checkSortedArr = { 1, 2, 3, 4, 5 };
        boolean isSortedAnswer = isSorted(checkSortedArr, checkSortedArr.length);
        System.out.println(isSortedAnswer);

        // Linear Search
        int[] linearSearchArray = { 3, 5, 1, 2, 6 };
        int keyToSearch = 7;
        System.out.println(linearSearch(linearSearchArray, keyToSearch, linearSearchArray.length));

        // binary search
        System.out.println(binarySearch(linearSearchArray, keyToSearch, linearSearchArray.length, 0,
                linearSearchArray.length - 1));

        // Reverse a string using recursion
        String str = "ABCD";
        int strSize = str.length();
        reverseString(str.toCharArray(), 0, strSize - 1);
        String str2 = new String(str);
        System.out.println(str2);

        // merge sort using recursion

        int[] mergeSortArr = { 10, 2, 3, 7, 1 };
        mergeSort(mergeSortArr, 0, mergeSortArr.length - 1);
        printArray(mergeSortArr);

        // quick sort using recursion

        int[] quickSortArr = { 10, 2, 1, 1, 5, 8 };
        quickSort(quickSortArr, 0, quickSortArr.length - 1);
        printArray(quickSortArr);

        // Subset recursion Very Important
        ArrayList<ArrayList<Integer>> alSubset = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> output = new ArrayList<>();
        int[] subsetArr = { 1, 2, 3 };
        solveSubset(subsetArr, 0, output, alSubset);
        System.out.println(alSubset);
    }
}
