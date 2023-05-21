import java.util.Arrays;
import java.util.HashSet;

public class SmallestPositiveMissingNumber {
    public static void main(String[] args) {
        int[] arr = {0,-10,1,3,-20};
        int n = arr.length;

        Arrays.sort(arr);
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<n;i++) {
            hs.add(arr[i]);
        }
        for(int i=1;i<=n;i++) {
            if(!hs.contains(i)) {
                System.out.println(i);
                break;
            }
        }
        System.out.println(arr[n-1]+1);
    }    
}
