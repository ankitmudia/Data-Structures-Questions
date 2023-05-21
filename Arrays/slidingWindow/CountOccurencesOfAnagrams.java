package slidingWindow;

import java.util.HashMap;

public class CountOccurencesOfAnagrams {

    static int solve(String txt, String pat) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < pat.length(); i++) {
            char ch = pat.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        int i = 0;
        int j = 0;
        int size = txt.length();
        int k = pat.length();
        int count = hm.size();
        int resultCount = 0;
        while (j < size) {
            char ch = txt.charAt(j);
            if (hm.containsKey(ch)) {
                hm.put(ch, hm.get(ch) - 1);
                if (hm.get(ch) == 0) {
                    count--;
                }
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (count == 0) {
                    resultCount++;
                }
                i++;
                j++;
            }
        }
        return resultCount;
    }

    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";

        System.out.println(solve(txt, pat));
    }
}
