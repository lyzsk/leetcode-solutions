import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2023/02/13
 **/
public class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (sum > 0) {
                res = Math.max(res, i + 1);
            } else {
                if (map.containsKey(sum - 1)) {
                    res = Math.max(res, i - map.get(sum - 1));
                }
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return res;
    }
}
