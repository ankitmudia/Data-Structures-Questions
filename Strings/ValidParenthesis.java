/**
 * ValidParenthesis
 */
/**
 * Using a stack to check if we match with the closing ans opening bracked, 
 * if so return true
 * else return false;
 */
import java.util.Stack;
public class ValidParenthesis {
    static boolean checkValid(String x) {
        Stack<Character> s = new Stack<>();
        for(int i=0;i<x.length();i++) {
            if(!s.isEmpty() && i<x.length()) {
                if(s.peek() == '[' && x.charAt(i) == ']' || s.peek() == '(' && x.charAt(i) == ')' || s.peek() == '{' && x.charAt(i) == '}') {
                    s.pop();
                } else {
                    s.push(x.charAt(i));
                }
            } else if(s.isEmpty() && i<x.length()) {
                s.push(x.charAt(i));
            }
        }
        if(s.isEmpty()) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        boolean ans = checkValid("{([])}"); 
        System.out.println(ans);      
    }
}