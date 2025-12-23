import java.util.*;

/**
 * @author sichu huang
 * @since 2025/12/21 13:53
 */
public class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        if (cnt.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }
        List<Integer> vals = new ArrayList<>(cnt.keySet());
        vals.sort(Comparator.comparingInt(Math::abs));
        for (int x : vals) {
            if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) {
                return false;
            }
            cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
        }
        return true;
    }
}
