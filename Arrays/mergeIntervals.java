import java.util.ArrayList;
import java.util.Arrays;

public class mergeIntervals {
    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 2, 4 }, { 6, 8 }, { 9, 10 } };
        Arrays.sort(arr, (i, j) -> {
            return i[0] - j[0];
        });
        ArrayList<int[]> al = new ArrayList<>();

        int start = arr[0][0];
        int end = arr[0][1];

        for (int[] i : arr) {
            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            } else {
                al.add(new int[] { start, end });
                start = i[0];
                end = i[1];
            }
        }
        al.add(new int[] { start, end });
        al.toArray(new int[0][]);
        for (int[] i : al) {
            System.out.println(i[0] + " " + i[1]);
        }
    }
}
