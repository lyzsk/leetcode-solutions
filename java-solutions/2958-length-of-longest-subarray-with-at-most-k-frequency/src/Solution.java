import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @date 2024/03/28
 **/
public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int res = 0;
        int left = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            cnt.merge(nums[right], 1, Integer::sum);
            while (cnt.get(nums[right]) > k) {
                cnt.merge(nums[left++], -1, Integer::sum);
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
