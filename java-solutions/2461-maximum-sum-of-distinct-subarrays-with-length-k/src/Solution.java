import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2024/11/19 17:04
 */
public class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        long s = 0;
        for (int i = 0; i < k - 1; i++) {
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            s += nums[i];
        }
        for (int i = k - 1; i < nums.length; i++) {
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            s += nums[i];
            if (cnt.size() == k) {
                res = Math.max(res, s);
            }
            int out = nums[i - k + 1];
            cnt.put(out, cnt.get(out) - 1);
            s -= out;
            if (cnt.get(out) == 0) {
                cnt.remove(out);
            }
        }
        return res;
    }
}
