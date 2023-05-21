import java.util.HashMap;
public class CountPairsWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1};
        int n = arr.length;
        int k = 2   ;
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(hm.containsKey(k-arr[i])) {
                count += hm.get(k-arr[1]);
            }
            if(hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i])+1);
            } else {
                hm.put(arr[i], 1);
            }
        }

        System.out.println(count);
    }
}
