import java.util.List;

/**
 * @author sichu huang
 * @since 2025/10/15 20:45
 */
public class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int res = 0;
        int n = nums.size();
        for (int i = 0, pre = 0, cur, j; i < n; i++) {
            j = i;
            while (i + 1 < n && nums.get(i + 1) > nums.get(i)) {
                i++;
            }
            cur = i - j + 1;
            res = Math.max(res, Math.max(Math.min(pre, cur), cur >> 1));
            pre = cur;
        }
        return res;
    }
}
