import java.util.HashMap;   
public class FindMissingRepeating {

    // brute force solution by making another data structure
    // which will keep the numbers from 1 to n,
    // and will also keep the count with it,
    // count 2 number will be repeating
    // count 0 number will be missing
    static void solve(int[] arr, int n) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> h = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (h.containsKey(arr[i])) {
                h.put(arr[i], h.get(arr[i]) + 1);
            } else {
                h.put(arr[i], 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (h.get(arr[i]) == 2) {
                answer[0] = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (h.containsKey(i + 1)) {
                continue;
            } else {
                answer[1] = i + 1;
                break;
            }
        }

        System.out.println("repeating - " + answer[0]);
        System.out.println("missing - " + answer[1]);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 2 };
        int n = 2;
        solve(arr, n);
    }
}
