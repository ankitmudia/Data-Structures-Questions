public class FindAFixedPoint {
    static void findFixed(int[] arr, int n) {
        int ans = -1;
        for (int i = 0; i < n-1; i++) {
            if (arr[i] == i+1) {
                ans = arr[i];
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int[] arr = { 15, 2, 45, 12, 7 };
        int n = 5;
        findFixed(arr, n);
    }
}
