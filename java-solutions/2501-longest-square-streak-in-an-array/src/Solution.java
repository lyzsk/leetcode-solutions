import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2024/10/28 21:58
 */
public class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[n - 1];
        int len = -1;
        int[] dp = new int[max + 1];
        for (int num : nums) {
            dp[num] = 1;
        }
        for (int num : nums) {
            int x = (int)Math.sqrt(num);
            if (x * x != num) {
                continue;
            }
            dp[num] = dp[x] + 1;
        }
        for (int i = 0; i <= max; i++) {
            if (dp[i] >= 2) {
                len = Math.max(len, dp[i]);
            }
        }
        return len;
    }
}
