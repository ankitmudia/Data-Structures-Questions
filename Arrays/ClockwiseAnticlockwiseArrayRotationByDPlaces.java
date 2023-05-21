public class ClockwiseAnticlockwiseArrayRotationByDPlaces {
    static void rotateArr(int[] arr, int s, int e) {
        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }

    static void antiClockWise(int[] arr, int n, int d) {
        d = d%n;
        rotateArr(arr, 0, d-1);
        rotateArr(arr, d, n-1);
        rotateArr(arr, 0, n-1);
    }

    static void clockWise(int[] arr, int n, int d) {
        System.out.println(n-d+1);
        d = d%n;
        rotateArr(arr, 0, n-d);
        // rotateArr(arr, n-d, n-1);
        // rotateArr(arr, 0, n-1);
    }

    static void printArr(int[] arr, int n) {
        for(int i=0;i<n;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
        int n = arr.length;
        int d = 3;
        // antiClockWise(arr, n, d);
        // printArr(arr, n);
        clockWise(arr, n, d);
        printArr(arr, n);
    }
}
