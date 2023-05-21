import java.util.Stack;

/**
 * ReverseStringUsingStack
 */
public class ReverseStringUsingStack {

    static String rev(String S) {
        String str = "";
        Stack st = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            st.push(S.charAt(i));
        }

        for (int i = 0; i < S.length(); i++) {
            str += st.pop();
        }

        return str;
    }

    public static void main(String[] args) {
        String S = "GeeksForGeeks";
        System.out.println(rev(S));
    }
}