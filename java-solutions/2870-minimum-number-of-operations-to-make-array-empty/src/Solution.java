import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2024/01/04
 **/
public class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            if (v == 1) {
                return -1;
            }
            res += v / 3;
            if (v % 3 != 0) {
                ++res;
            }
        }
        return res;
    }
}
