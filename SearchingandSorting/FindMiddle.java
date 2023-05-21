public class FindMiddle {
    static int middle(int A, int B, int C) {
        if (A > B && A < C || A < B && A > C) {
            return A;
        } else if (B > A && B < C || B < A && B > C) {
            return B;
        } else {
            return C;
        }
    }   

    public static void main(String[] args) {
        System.out.println(middle(978, 518, 300));
    }
}
