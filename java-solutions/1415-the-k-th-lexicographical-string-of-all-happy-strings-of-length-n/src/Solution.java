/**
 * @author sichu huang
 * @since 2025/02/19 16:12
 */
public class Solution {
    private String res = "";

    public String getHappyString(int n, int k) {
        res = "";
        solve(0, new int[] {k}, n, new char[] {'a', 'b', 'c'}, new StringBuilder());
        return res;
    }

    private void solve(int len, int[] cnt, int n, char[] chars, StringBuilder sb) {
        if (len == n) {
            if (--cnt[0] == 0) {
                res = sb.toString();
            }
            return;
        }
        for (char c : chars) {
            if (len == 0 || sb.charAt(len - 1) != c) {
                sb.append(c);
                solve(len + 1, cnt, n, chars, sb);
                sb.deleteCharAt(sb.length() - 1);
                if (cnt[0] == 0) {
                    return;
                }
            }
        }
    }
}
