/**
 *
 * @author sichu huang
 * @since 2026/03/07 14:10
 */
public class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int[][] pre = new int[n][2];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            pre[i][0] = (i == 0 ? 0 : pre[i - 1][1]) + (ch == '1' ? 1 : 0);
            pre[i][1] = (i == 0 ? 0 : pre[i - 1][0]) + (ch == '0' ? 1 : 0);
        }

        int res = Math.min(pre[n - 1][0], pre[n - 1][1]);
        if (n % 2 == 1) {
            int[][] suf = new int[n][2];
            for (int i = n - 1; i >= 0; i--) {
                char ch = s.charAt(i);
                suf[i][0] = (i == n - 1 ? 0 : suf[i + 1][1]) + (ch == '1' ? 1 : 0);
                suf[i][1] = (i == n - 1 ? 0 : suf[i + 1][0]) + (ch == '0' ? 1 : 0);
            }

            for (int i = 0; i < n - 1; i++) {
                res = Math.min(res, pre[i][0] + suf[i + 1][0]);
                res = Math.min(res, pre[i][1] + suf[i + 1][1]);
            }
        }

        return res;
    }
}
