import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2024/11/16 17:07
 */
public class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Arrays.fill(res, -1);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt = i == 0 || nums[i] - nums[i - 1] != 1 ? 1 : cnt + 1;
            if (cnt >= k) {
                res[i - k + 1] = nums[i];
            }
        }
        return res;
    }
}
