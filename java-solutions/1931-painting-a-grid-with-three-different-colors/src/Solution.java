import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2025/05/18 13:55
 */
public class Solution {
    private static final int mod = (int)(1e9 + 7);

    private static Map<Integer, List<Integer>> getMap(int m) {
        Map<Integer, List<Integer>> valid = new HashMap<>();
        int maskEnd = (int)Math.pow(3, m);
        for (int mask = 0; mask < maskEnd; ++mask) {
            List<Integer> color = new ArrayList<>();
            int mm = mask;
            for (int i = 0; i < m; ++i) {
                color.add(mm % 3);
                mm /= 3;
            }
            boolean check = true;
            for (int i = 0; i < m - 1; ++i) {
                if (color.get(i).equals(color.get(i + 1))) {
                    check = false;
                    break;
                }
            }
            if (check) {
                valid.put(mask, color);
            }
        }
        return valid;
    }

    public int colorTheGrid(int m, int n) {
        Map<Integer, List<Integer>> valid = getMap(m);
        Map<Integer, List<Integer>> adjacent = new HashMap<>();
        for (int mask1 : valid.keySet()) {
            for (int mask2 : valid.keySet()) {
                boolean check = true;
                for (int i = 0; i < m; ++i) {
                    if (valid.get(mask1).get(i).equals(valid.get(mask2).get(i))) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    adjacent.computeIfAbsent(mask1, k -> new ArrayList<>()).add(mask2);
                }
            }
        }
        Map<Integer, Integer> f = new HashMap<>();
        for (int mask : valid.keySet()) {
            f.put(mask, 1);
        }
        for (int i = 1; i < n; ++i) {
            Map<Integer, Integer> g = new HashMap<>();
            for (int mask2 : valid.keySet()) {
                for (int mask1 : adjacent.getOrDefault(mask2, new ArrayList<>())) {
                    g.put(mask2, (g.getOrDefault(mask2, 0) + f.getOrDefault(mask1, 0)) % mod);
                }
            }
            f = g;
        }
        int res = 0;
        for (int num : f.values()) {
            res = (res + num) % mod;
        }
        return res;
    }
}
