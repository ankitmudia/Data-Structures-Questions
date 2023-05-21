/**
 * moveNegativesToRight
 */
/**
 * BruteForce
 * we can use extra space, store all the positives in that array
 * and after that loop for negatives and store them in the end
 * 
 * optimised(Using a pointer)
 * we will initialize p with -1;
 * will loop the array and check if arr[i]>=0,
 * if so, we will increment p by 1,
 * and will swap, arr[i], arr[p];
 * end result, negatives will be moved to right;
 */
public class moveNegativesToRight {
    public static void main(String[] args) {
        int[] arr = {-5, 7, -3, -4, 9, 10, -1, 11};
        int n = arr.length;
        int p = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                p++;
                int temp = arr[i];
                arr[i] = arr[p];
                arr[p] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}