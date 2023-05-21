
/*
 * Declare a character stack (say temp).
Now traverse the string exp. 
If the current character is a starting bracket ( ‘(‘ or ‘{‘  or ‘[‘ ) then push it to stack.
If the current character is a closing bracket ( ‘)’ or ‘}’ or ‘]’ ) then pop from stack and
if the popped character is the matching starting bracket then fine.
Else brackets are Not Balanced.
After complete traversal, if there is some starting bracket left in stack then Not balanced,
else Balanced.
 */
import java.util.*;

public class ParenthesisChecker {
    public static void main(String[] args) {
        String x = "([]";
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < x.length(); i++) {
            if (!s.isEmpty() && i < x.length()) {
                if (s.peek() == '[' && x.charAt(i) == ']' || s.peek() == '(' && x.charAt(i) == ')'
                        || s.peek() == '{' && x.charAt(i) == '}') {
                    s.pop();
                } else {
                    s.push(x.charAt(i));
                }
            } else if (s.isEmpty() && i < x.length()) {
                s.push(x.charAt(i));
            }
        }
        if (s.isEmpty()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
