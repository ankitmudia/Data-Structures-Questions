/**
 * SelectionSort -
 * Set the first element as minimum.
 * Compare minimum with the second element.
 * If the second element is smaller than minimum, assign the second element as
 * minimum.
 * Compare minimum with the third element. Again, if the third element is
 * smaller, then assign minimum to the third element otherwise do nothing.
 * The process goes on until the last element.
 * After each iteration, minimum is placed in the front of the unsorted list.
 * For each iteration, indexing starts from the first unsorted element.
 * Step 1 to 3 are repeated until all the elements are placed at their correct
 * positions.
 */
public class SelectionSort {

    // static void sort(int[] arr, int n) {
    // for (int i = 0; i < n - 1; i++) {
    // int minimum = i;
    // for (int j = i + 1; j < n; j++) {
    // if (arr[j] < arr[minimum]) {
    // minimum = j;
    // }
    // }
    // int temp = arr[i];
    // arr[i] = arr[minimum];
    // arr[minimum] = temp;
    // }
    // }

    static void sort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < min) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
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