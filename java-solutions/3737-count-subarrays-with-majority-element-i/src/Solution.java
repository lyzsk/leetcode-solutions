/**
 *
 * @author sichu huang
 * @since 2026/06/25
 */
public class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int res = 0;

        for (int l = 0; l < n; l++) {
            int targetCount = 0;

            for (int r = l; r < n; r++) {
                if (nums[r] == target) {
                    targetCount++;
                }

                int len = r - l + 1;

                if (targetCount > len / 2) {
                    res++;
                }
            }
        }

        return res;
    }
}
