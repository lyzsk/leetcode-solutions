import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2023/10/16
 **/
public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int idx = 0;
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res[idx++] = entry.getKey();
            }
        }
        return res;
    }
}
