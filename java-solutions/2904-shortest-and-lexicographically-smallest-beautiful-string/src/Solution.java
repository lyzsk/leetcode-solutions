/**
 *
 * @author sichu huang
 * @since 2026/08/26
 */
public class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        for (int m = k; m <= n; m++) {
            String res = "";
            for (int i = m; i <= n; i++) {
                String t = s.substring(i - m, i);
                int cnt = 0;
                for (int j = 0; j < t.length(); j++) {
                    cnt += t.charAt(j) - '0';
                }
                if ((res.isEmpty() || t.compareTo(res) < 0) && cnt == k) {
                    res = t;
                }
            }
            if (!res.isEmpty()) {
                return res;
            }
        }
        return "";
    }
}
