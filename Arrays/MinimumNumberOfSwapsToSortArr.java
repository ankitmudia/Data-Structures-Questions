import java.util.HashMap;
import java.util.Arrays;

public class MinimumNumberOfSwapsToSortArr {
    static int solve(int[] arr, int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] tempArr = new int[n];

        for (int i = 0; i < n; i++) {
            hm.put(arr[i], i);
            tempArr[i] = arr[i];
        }

        Arrays.sort(tempArr);

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != tempArr[i]) {
                int index = hm.get(tempArr[i]);

                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                count++;

                hm.put(arr[i], i);
                hm.put(tempArr[index], index);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 8, 5, 4 };
        int n = arr.length;

        System.out.println(solve(arr, n));
    }
}
