/**
 *
 * @author sichu huang
 * @since 2026/05/25 17:33
 */
public class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        int[] dp = new int[n];
        int[] pre = new int[n];
        dp[0] = 1;
        for (int i = 0; i < minJump; i++) {
            pre[i] = 1;
        }
        for (int i = minJump; i < n; i++) {
            int left = i - maxJump;
            int right = i - minJump;
            if (s.charAt(i) == '0') {
                int total = pre[right] - (left <= 0 ? 0 : pre[left - 1]);
                dp[i] = total != 0 ? 1 : 0;
            }
            pre[i] = pre[i - 1] + dp[i];
        }
        return dp[n - 1] == 1;
    }
}
