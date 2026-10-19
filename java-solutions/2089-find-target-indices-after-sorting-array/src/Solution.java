import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sichu huang
 * @since 2026/10/19
 */
public class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                res.add(i);
            }
        }
        return res;
    }
}
