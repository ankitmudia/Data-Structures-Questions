/**
 * Permutation
 * Through recurssion and backtracking approach
 */
import java.util.*;
public class Permutation {

    static ArrayList<String> al = new ArrayList<>();
    static HashSet<String> hs = new HashSet<>();

    public static void solve(String S, StringBuilder ans, boolean[] freq) {
        if(ans.length() == S.length()) {
            hs.add(ans.toString());
            return;
        }
        
        for(int i=0;i<S.length();i++) {
            if(!freq[i]) {
                freq[i] = true;
                ans.append(S.charAt(i));
                solve(S, ans, freq);
                ans.deleteCharAt(ans.length()-1);
                freq[i] = false;
            }
        }
        
    }

    public static void main(String[] args) {
        String S = "ABC";
        boolean[] freq = new boolean[S.length()];
        StringBuilder ans = new StringBuilder();
        solve(S, ans, freq);
        
        for(String s: hs) {
            al.add(s);
        }
        
        Collections.sort(al);
        System.out.println(al);
    }
}