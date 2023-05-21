/**
 * CheckPalindrome
 */
/**
 * approach
 * brute force - 
 * we will take extra space and reverse the first string
 * then we will compare it with the original string 
 * and get the answer
 * 
 * optimised approach - 
 * using a 2 pointer approach, with start and end pointer
 */
public class CheckPalindrome {

    static boolean checkPal(String str) {
        int n = str.length()-1;
        int i = 0;
        int j = n;
        while (i <= j) {
            int s = str.charAt(i);
            int e = str.charAt(j);
            if(s != e) {
                return false;
            }
            else {
                i++;
                j--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        boolean ans = checkPal("abc");

        System.out.println(ans);
    }
}
