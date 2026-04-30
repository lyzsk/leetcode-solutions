import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author sichu huang
 * @since 2026/04/23 17:43
 */
public class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            groups.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        long[] res = new long[n];
        for (List<Integer> group : groups.values()) {
            long total = 0;
            for (int idx : group) {
                total += idx;
            }
            long prefixTotal = 0;
            int sz = group.size();
            for (int i = 0; i < sz; i++) {
                int idx = group.get(i);
                res[idx] = total - prefixTotal * 2 + (long)idx * (2 * i - sz);
                prefixTotal += idx;
            }
        }
        return res;
    }
}
