import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PracticeArrays {
    static void printArr(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void swapArr(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    static void reverseArr(int[] arr, int n) {
        int l = 0;
        int r = n - 1;
        while (l < r) {
            swapArr(arr, l, r);
            l++;
            r--;
        }
    }

    static int LinearSearch(int[] arr, int key, int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    static void swapAlternate(int[] arr, int n) {
        for (int i = 0; i < n - 1; i += 2) {
            swapArr(arr, i, i + 1);
        }
    }

    static void findUnique(int[] arr, int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans ^ arr[i];
        }
        System.out.println(ans);
    }

    static void findDup(int[] arr, int n) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = ans ^ arr[i];
        }
        for (int i = 1; i < arr.length; i++) {
            ans = ans ^ i;
        }
        System.out.println(ans);
    }

    static void pairSum(int[] arr, int sum, int n, ArrayList<ArrayList<Integer>> al) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; i < n - 1; i++) {
                if (arr[i] + arr[j] == sum) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(Math.min(arr[i], arr[j]));
                    temp.add(Math.max(arr[i], arr[j]));
                    al.add(temp);
                }
            }
        }
    }

    static void merge2SortedArr(int[] arr1, int[] arr2, int[] arr3) {
        int n = 0;
        int m = 0;
        int k = 0;

        while (n < arr1.length && m < arr2.length) {
            if (arr1[n] < arr2[m]) {
                arr3[k] = arr1[n];
                n++;
                k++;
            } else if (arr2[m] < arr1[n]) {
                arr3[k] = arr2[m];
                m++;
                k++;
            }
        }
        while (n < arr1.length) {
            arr3[k++] = arr1[n++];
        }
        while (m < arr2.length) {
            arr3[k++] = arr1[m++];
        }
    }

    static void moveZeroToEnd(int[] arr, int n) {
        int nonZero = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[nonZero];
                arr[nonZero] = temp;
                nonZero++;
            }
        }
    }

    static void rotateByKPlace(int[] arr, int n, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = k; i < n; i++) {
            al.add(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            al.add(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            arr[i] = al.get(i);
        }
    }

    static void checkSolve(int[] arr, int n) {
        Set<Integer> hs = new HashSet<>();
        boolean flag = true;
        for(int i=0;i<n;i++) {
            hs.add(arr[i]);
        }
        ArrayList<Integer> al = new ArrayList<>();
        for(int element: hs) {
            al.add(element);
        }
        for(int i=al.size()-1;i>0;i--) {
            if(al.get(i)-1 != al.get(i-1)) {
                // System.out.println(al.get(i)-1+" "+al.get(i-1));
                flag = false;
            }
        }
        System.out.println(flag);
    }

    public static void main(String[] args) {
        // First - Reverse
        int[] arr = { 1, 2, 3, 4, 5 };
        printArr(arr, arr.length);
        reverseArr(arr, arr.length);
        printArr(arr, arr.length);

        // Second Linear Search
        int keyToSearch = 3;
        int linearSearchAnswer = LinearSearch(arr, keyToSearch, arr.length);
        System.out.println("Key Found at " + linearSearchAnswer);

        // Third - Swap Alternate
        int[] arrSwapAlternate = { 1, 2, 3, 4, 5, 6 };
        printArr(arrSwapAlternate, arrSwapAlternate.length);
        swapAlternate(arrSwapAlternate, arrSwapAlternate.length);
        printArr(arrSwapAlternate, arrSwapAlternate.length);

        // Find unique element using xor
        // case - every element in array occurs twice except one element
        // return that one element
        int[] findUniqueElement = { 1, 2, 3, 2, 1, 4, 3 };
        findUnique(findUniqueElement, findUniqueElement.length);

        // Find duplicate using xor
        // case - we have numbers from 1 to n-1, and one number occurs twice in
        // the array, return that number
        int[] arrWithDuplicate = { 4, 3, 1, 2, 1 };
        findDup(arrWithDuplicate, arrWithDuplicate.length);

        int[] pairSumArray = { 1, 2, 3, 4, 5 };
        int sumToBe = 5;
        // ArrayList<Integer> psAnswer = new ArrayList<>();
        ArrayList<ArrayList<Integer>> psAnswer = new ArrayList<ArrayList<Integer>>();
        pairSum(pairSumArray, sumToBe, pairSumArray.length, psAnswer);
        System.out.println("pair sum: " + psAnswer);

        // merge 2 sorted arrays
        int[] firstArr = { 1, 3, 5, 7, 9 };
        int[] secondArr = { 2, 4, 6 };
        int[] thirdArr = new int[firstArr.length + secondArr.length];
        merge2SortedArr(firstArr, secondArr, thirdArr);
        printArr(thirdArr, thirdArr.length);

        // Move zeroes to end
        int[] zerosToEnd = { 0, 2, 0, 1, 3, 0, 0, 0 };
        moveZeroToEnd(zerosToEnd, zerosToEnd.length);
        printArr(zerosToEnd, zerosToEnd.length);

        //Rotate Array By K Places
        int[] rotateArr = { 1, 7, 9, 11 };
        printArr(rotateArr, rotateArr.length);
        rotateByKPlace(rotateArr, rotateArr.length, 2);
        printArr(rotateArr, rotateArr.length);
        System.out.println("-------------------------------------");

        int[] a = {2,6,1,9,4,5,3};
        int aLength = a.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<aLength;i++) {
            hs.add(a[i]);
        }
        System.out.println(hs);
        System.out.println("=====================================");
        int[] temparrr1 = {10, 14, 10, 12, 12, 
            13, 15};
        // int tempLen = temparrr.length;
        checkSolve(temparrr1, temparrr1.length);
    }
}
