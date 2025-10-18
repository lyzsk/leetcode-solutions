import java.util.List;

/**
 * @author sichu huang
 * @since 2025/10/15 02:40
 */
public class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for (int i = 0, j, pre = 0, cur; i < n; i++) {
            j = i;
            while (i + 1 < n && nums.get(i + 1) > nums.get(i)) {
                i++;
            }
            cur = i - j + 1;
            if (cur >= k * 2 || (pre >= k && cur >= k)) {
                return true;
            }
            pre = cur;
        }
        return false;
    }
}
