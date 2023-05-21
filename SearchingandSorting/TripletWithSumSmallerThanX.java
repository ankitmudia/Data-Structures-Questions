/*
 * two approaches to solve - 
 * brute force - Take 3 loops and check for everyi, j, k, 
 * it will take O(n)^3 TC;
 * 
 * Optimised approach - 
 * we will solve in O(n)^2, 
 * Sort the array, will run a loop with i from 0 - n-2;
 * will place j on i+1 and k on n-1;
 * in another while loop(j<k), will check if sum of all three is less than given sum
 * will add count of k - j to the result and will increment j++;
 * else no forward element will be less than the sum, will decrement k;
 */

import java.util.Arrays;

public class TripletWithSumSmallerThanX {

    static int solve(int[] arr, int n, int sum) {
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int result = arr[i] + arr[j] + arr[k];
                if (result < sum) {
                    ans += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { -2, 0, 1, 3 };
        int n = 4;
        int sum = 2;
        int ans = solve(arr, n, sum);
        System.out.println(ans);
    }
}
