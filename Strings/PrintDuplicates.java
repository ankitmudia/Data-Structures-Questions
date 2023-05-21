/**
 * PrintDuplicates
 */
public class PrintDuplicates {

    static void Duplicate(String str) {
        int[] counts = new int[256];
        for(int i=0;i<str.length();i++) {
            counts[str.charAt(i)]++;
        }

        for(int i=0;i<counts.length;i++) {
            System.out.print(counts[i]);
        }
    }
    public static void main(String[] args) {
        Duplicate("test string");
    }
}