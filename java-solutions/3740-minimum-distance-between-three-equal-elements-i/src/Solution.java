/**
 *
 * @author sichu huang
 * @since 2026/04/10 14:56
 */
public class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int res = n + 1;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[i] != nums[j]) {
                    continue;
                }
                for (int k = j + 1; k < n; k++) {
                    if (nums[j] == nums[k]) {
                        res = Math.min(res, k - i);
                        break;
                    }
                }
            }
        }

        return res == n + 1 ? -1 : res * 2;
    }
}
