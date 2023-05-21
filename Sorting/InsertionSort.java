/*
 * The first element in the array is assumed to be sorted.
 * Take the second element and store it separately in key.
Compare key with the first element.
If the first element is greater than key, then key is placed in front of the first element.
Now, the first two elements are sorted.
Take the third element and compare it with the elements on the left of it.
Placed it just behind the element smaller than it.
If there is no element smaller than it, then place it at the beginning of the array.
Similarly, place every unsorted element at its correct position.
 */
public class InsertionSort {
    static void sortWithWhile(int[] arr, int n) {
        int i = 0;
        while (i < n) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
                j--;
            }
            arr[j + 1] = temp;
            i++;
        }
    }

    static void sort(int[] arr, int n) {
        // run loop from 1 because we consider 0th element as sorted
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                // shift
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] data = { -2, 45, 0, 11, -9 };
        int n = data.length;
        for (int i = 0; i < n; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        sortWithWhile(data, n);
        for (int i = 0; i < n; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
