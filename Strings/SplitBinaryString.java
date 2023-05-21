/**
 * InnerSplitBinaryString
 */
/**
 * Approach - 
 * will count number of zero's and number of one's
 * if they are not equal return -1;
 * if equal return the finalCount which will contain counts of zero/ones;
 */
public class SplitBinaryString {

    public static void main(String[] args) {
        String s = "0111100010";
        int n = s.length();
        int count0 = 0;
        int count1 = 0;
        int finalCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }
            if (count0 == count1) {
                finalCount++;
            }
        }
        if (count0 != count1) {
            System.out.println("-1");
        }
        System.out.println(finalCount);
    }
}
