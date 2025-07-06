import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2025/07/06 01:37
 */
public class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int x : arr) {
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        int res = -1;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (key == value) {
                res = Math.max(res, key);
            }
        }
        return res;
    }
}
