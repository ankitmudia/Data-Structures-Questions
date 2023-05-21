/*
 * bubble sort algorithm - 
 * 1. First Iteration (Compare and Swap)
    Starting from the first index, compare the first and the second elements.
    If the first element is greater than the second element, they are swapped.
    Now, compare the second and the third elements. Swap them if they are not in order.
    The above process goes on until the last element.
2. Remaining Iteration
    The same process goes on for the remaining iterations.
    After each iteration, the largest element among the unsorted elements is placed at the end.    
3. In each iteration, the comparison takes place up to the last unsorted element.
4. The array is sorted when all the unsorted elements are placed at their correct positions.
 */

public class BubbleSort {

    // static void sort(int[] arr, int n) {
    // for (int i = 0; i < n-1; i++) {
    // for (int j = 0; j < n - i - 1; j++) {
    // // swap if found greater
    // if (arr[j] > arr[j + 1]) {
    // int temp = arr[j];
    // arr[j] = arr[j + 1];
    // arr[j + 1] = temp;
    // }
    // }
    // }
    // }

    static void sort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = { -2, 45, 0, 11, -9 };
        int n = data.length;
        for (int i = 0; i < n; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        sort(data, n);
        for (int i = 0; i < n; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
