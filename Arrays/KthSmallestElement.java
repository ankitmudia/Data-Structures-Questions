import java.util.PriorityQueue;
import java.util.Collections;

/**
 * KthSmallestElement
 */

/**
 * - BruteForce approach
 * - Sort the Array and return the kth element.
 * 
 * - optimised approach is using a min heap
 * - put the elements in a priority queue
 * - pop the elements kth times and you can have your answer
 * NOTE:- if using a max heap - we have to pop the elements - (n-k+1), do a dry
 * run
 * to understand on pen and paper
 */

public class KthSmallestElement {
    // PriorityQueue<Integer> p = new PriorityQueue<Integer>();

    // for(int i=0;i<=r;i++) {
    // p.add(arr[i]);
    // if(p.size() > k) {
    // p.poll();
    // }
    // }

    // return p.peek();
    static int solve(int[] arr, int n, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int ans = -1;
        for (int i = 0; i < n; i++) {
            q.add(arr[i]);
            if (q.size() > k) {
                q.poll();
            }
        }
        ans = q.poll();
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 10, 4, 3, 20, 15 };
        int n = arr.length;
        int k = 4;
        int ans = solve(arr, n, k);
        System.out.println(ans);
    }
}