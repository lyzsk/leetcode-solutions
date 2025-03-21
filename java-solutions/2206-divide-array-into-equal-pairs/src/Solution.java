import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2025/03/17 18:26
 */
public class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        for (int count : counter.values()) {
            if (count % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
