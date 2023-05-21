/**
 * minimumNumOfJumps
 */
/**
 * 
 */
public class minimumNumOfJumps {
    static void solve(int[] arr, int n) {
        if(arr[0] == 0) {
            System.out.println("-1");
        }

        int count = 0;
        int val;
        for(int i=0;i<n-1;) {
            // if(i >= n-1) {
            //     System.out.println("val: "+count);
            //     return;
            // }
            val = arr[i];
            i += val;
            count++;
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 6, 7};
        int n = arr.length;
        solve(arr, n);
        // int n = arr.length  ;
        // if(n == 1) {
        //     return 0;
        // }
        // if(arr[0] == 0) {
        //     return -1;
        // }
        // int range = arr[0];
        // int steps = arr[0];
        // int jumps = 1;
        // for(int i=1;i<n;i++) {
        //     if(i == n-1) {
        //         return jumps;
        //     }
        //     range = Math.max(range, i+arr[i]);
        //     steps--;
        //     if(steps == 0) {
        //         jumps++;
        //         if(i>=range) {
        //             return -1;
        //         }
        //         steps = range-i;
        //     }
        // }
        // return -1;
    }
}