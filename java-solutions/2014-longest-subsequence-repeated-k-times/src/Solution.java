import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu huang
 * @since 2025/06/28 02:00
 */
public class Solution {

    public String longestSubsequenceRepeatedK(String s, int k) {
        String r = "";
        Deque<String> q = new ArrayDeque<>();
        for (q.add(""); !q.isEmpty(); ) {
            String c = q.poll();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String n = c + ch;
                if (isK(n, s, k)) {
                    r = n;
                    q.add(n);
                }
            }
        }
        return r;
    }

    private boolean isK(String s, String t, int k) {
        int c = 0, i = 0;
        for (char ch : t.toCharArray()) {
            if (ch == s.charAt(i)) {
                if (++i == s.length()) {
                    i = 0;
                    if (++c == k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
