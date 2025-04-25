import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2025/04/20 12:53
 */
public class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int y : answers) {
            count.put(y, count.getOrDefault(y, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int y = entry.getKey(), x = entry.getValue();
            res += (x + y) / (y + 1) * (y + 1);
        }
        return res;
    }
}
