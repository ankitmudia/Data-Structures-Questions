import java.util.HashMap;

public class MajorityElement {

    static int majorityElement(HashMap<Integer, Integer> hm, int n) {
        for (Integer i : hm.keySet()) {
            if (hm.get(i) > n) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 3, 3, 2 };
        int n = arr.length / 2;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i : arr) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        System.out.println(majorityElement(hm, n));
    }
}
