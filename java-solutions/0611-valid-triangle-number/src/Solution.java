import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2025/09/27 02:13
 */
public class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < n; ++i) {
            int k = i;
            for (int j = i + 1; j < n; ++j) {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                    ++k;
                }
                res += Math.max(k - j, 0);
            }
        }
        return res;
    }
}
