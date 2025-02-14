import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2025/02/09 10:59
 */
public class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i] - i, map.getOrDefault(nums[i] - i, 0) + 1);
        }
        long goodPairs = 0;
        for (Map.Entry<Integer, Integer> enty : map.entrySet()) {
            int val = enty.getValue();
            if (val >= 2) {
                goodPairs += (long)val * (val - 1) / 2;
            }
        }
        return (long)(n - 1) * n / 2 - goodPairs;
    }
}
