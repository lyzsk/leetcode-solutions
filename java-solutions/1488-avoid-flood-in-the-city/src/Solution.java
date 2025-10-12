import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author sichu huang
 * @since 2025/10/08 07:57
 */
public class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] res = new int[rains.length];
        Arrays.fill(res, 1);
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rains.length; ++i) {
            if (rains[i] == 0) {
                set.add(i);
            } else {
                res[i] = -1;
                if (map.containsKey(rains[i])) {
                    Integer it = set.ceiling(map.get(rains[i]));
                    if (it == null) {
                        return new int[0];
                    }
                    res[it] = rains[i];
                    set.remove(it);
                }
                map.put(rains[i], i);
            }
        }
        return res;
    }
}
