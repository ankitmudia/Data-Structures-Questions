package slidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumOfAllSubarraySizeK {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int n = arr.length;
        int k = 3;
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        int i = 0;
        int j = 0;
        while (j < n) {
            if (dq.size() == 0) {
                dq.add(arr[j]);
            } else {
                while (dq.size() > 0 && arr[j] > dq.peekLast()) {
                    dq.removeLast();
                }
                dq.add(arr[j]);
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                result.add(dq.peek());
                if(arr[i] == dq.peek()) {
                    dq.removeFirst();
                }
                i++;
                j++;
            }
        }
        System.out.println(result);
    }
}
