import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author sichu huang
 * @since 2026/10/15
 */
public class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size(), res = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = i; j < n; j++) {
                s.add(nums.get(j));
                res += s.size() * s.size();
            }
        }
        return res;
    }
}
