
//create a mapping of element and its index;
//now sort the array;
//initialize a variable swaps with 0, 
//start from the first element, swap it with it's correct index, and increment swaps on each swap;
//return swaps;
import java.util.Arrays;
import java.util.HashMap;

public class MinimumSwapsToSort {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = { 10, 19, 6, 3, 5 };
        int swaps = 0;
        HashMap<Integer, Integer> h = new HashMap<>();
        int[] tempArr = new int[n];

        for (int i = 0; i < n; i++) {
            tempArr[i] = arr[i];
            h.put(arr[i], i);
        }

        Arrays.sort(tempArr);
        for (int i = 0; i < n; i++) {
            if (arr[i] != tempArr[i]) {
                int index = h.get(tempArr[i]);

                // swap
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                swaps++;

                // update hashmap
                h.put(arr[i], i);
                h.put(arr[index], index);
            }
        }
        System.out.println(swaps);
    }
}
