package slidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeInWindowSizeK {

    static void solve(int[] arr, int n, Queue<Integer> q,
            ArrayList<Integer> al, int k) {
        int i = 0;
        int j = 0;
        while (j < n) {
            if (arr[j] < 0) {
                q.add(arr[j]);
            }
            if (j - i + 1 < k) {
                j++;
            } else {
                if (!q.isEmpty()) {
                    al.add(q.peek());
                    if (arr[i] == q.peek()) {
                        q.remove();
                    }
                } else {
                    al.add(0);
                }
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int n = arr.length;
        int k = 3;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> al = new ArrayList<>();
        solve(arr, n, q, al, k);
        System.out.println(al);
    }
}
