import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @date 2024/10/01
 **/
public class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put((num % k + k) % k,
                map.getOrDefault((num % k + k) % k, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int t = entry.getKey();
            int occ = entry.getValue();
            if (t > 0 && map.getOrDefault(k - t, 0) != occ) {
                return false;
            }
        }
        return map.getOrDefault(0, 0) % 2 == 0;
    }
}
