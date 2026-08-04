import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sichu huang
 * @since 2026/08/04
 */
public class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums[i] + 1; j < nums[i + 1]; j++) {
                res.add(j);
            }
        }
        return res;
    }
}
