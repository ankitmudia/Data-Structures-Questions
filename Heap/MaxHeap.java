import java.util.Scanner;

public class MaxHeap {

    static void printHeap(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i; // initialize current node as largest;
        int left = 2 * i + 1; // position of left child in array
        int right = 2 * i + 2; // position of right child array

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(arr, n, largest);
        }

    }

    static void buildHeap(int[] arr, int n) {
        // index of last non-leaf node;
        int index = (n / 2) - 1;

        for (int i = index; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of Array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter Array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        buildHeap(arr, n);
        printHeap(arr, n);
        sc.close();
    }
}
