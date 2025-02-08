import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2025/02/06 19:24
 */
public class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int key = nums[i] * nums[j];
                cnt.put(key, cnt.getOrDefault(key, 0) + 1);
            }
        }
        int res = 0;
        for (Integer v : cnt.values()) {
            res += v * (v - 1) * 4;
        }
        return res;
    }
}
