/**
 * Sort012
 */
/**
 * bruteForce
 * Count number of 0, 1 and 2 in the array
 * Run the loop for that many times and populate the same array with 0, 1 and 2
 * , in sequence
 * 
 * using dutch national flag algorithm
 * we will take 2 pointer low, mid, high
 * will set low and mid on arr[0] and high on arr[n-1];
 * condition should satisfy arr[0]<-->arr[low-1] = 0, arr[low]<-->arr[mid-1] =
 * 1, arr[high+1]-> = 2
 * if(mid == 0) {swap arr[low],arr[mid]} {low++, mid++}
 * if(mid == 1) {mid++}
 * if(mid == 2) {swap arr[mid], arr[high]} {high--}
 */
public class Sort012 {

    static void solve(int[] arr, int n) {
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0: {
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    int temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                    break;
                }
            }
        }
    }

    static void print(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // int zero = 0;
        // int one = 0;
        // int two = 0;
        // for(int i=0;i<n;i++) {
        // if(a[i] == 0) {
        // zero++;
        // }
        // if(a[i] == 1) {
        // one++;
        // }
        // if(a[i] == 2) {
        // two++;
        // }
        // }
        // int i = 0;
        // while(zero != 0) {
        // a[i] = 0;
        // i++;
        // zero--;
        // }
        // while(one != 0) {
        // a[i] = 1;
        // i++;
        // one--;
        // }
        // while(two != 0) {
        // a[i] = 2;
        // i++;
        // two--;
        // }

        // ================optimised approach====================================
        // int low = 0;
        // int mid = 0;
        // int high = n-1;
        // int temp;
        // while(mid<=high) {
        // switch(a[mid]) {
        // case 0: {
        // temp = a[low];
        // a[low] = a[mid];
        // a[mid] = temp;
        // low++;
        // mid++;
        // break;
        // }
        // case 1: {
        // mid++;
        // break;
        // }
        // case 2: {
        // temp = a[mid];
        // a[mid] = a[high];
        // a[high] = temp;
        // high--;
        // break;
        // }
        // }
        int[] arr = { 0, 2, 1, 2, 0 };
        int n = arr.length;
        print(arr, n);
        solve(arr, n);
        print(arr, n);
    }
}