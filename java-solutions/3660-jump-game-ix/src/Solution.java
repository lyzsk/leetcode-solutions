/**
 *
 * @author sichu huang
 * @since 2026/05/07 17:02
 */
public class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] pre = new int[n];
        int[] suf = new int[n];
        int[] res = new int[n];

        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i - 1], nums[i]);
        }

        suf[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = Math.min(suf[i + 1], nums[i]);
        }

        res[n - 1] = pre[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (pre[i] > suf[i + 1]) {
                res[i] = res[i + 1];
            } else {
                res[i] = pre[i];
            }
        }

        return res;
    }
}
