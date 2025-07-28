import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2025/07/22 23:15
 */
public class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        Set<Integer> seen = new HashSet<>();
        int res = 0, psum = 0;
        for (int i = 0, j = 0; i < n; ++i) {
            psum += nums[i];
            while (seen.contains(nums[i])) {
                seen.remove(nums[j]);
                psum -= nums[j];
                j++;
            }
            seen.add(nums[i]);
            res = Math.max(res, psum);
        }
        return res;
    }
}
