import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2025/07/01 00:47
 */
public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        for (int key : cnt.keySet()) {
            if (cnt.containsKey(key + 1)) {
                res = Math.max(res, cnt.get(key) + cnt.get(key + 1));
            }
        }
        return res;
    }
}
