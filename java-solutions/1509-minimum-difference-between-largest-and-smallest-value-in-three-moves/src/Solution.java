import java.util.Arrays;

/**
 * @author sichu huang
 * @date 2024/07/03
 **/
public class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int res = nums[nums.length - 1] - nums[0];
        for (int i = 0; i <= 3; i++) {
            res = Math.min(res, nums[nums.length - (3 - i) - 1] - nums[i]);
        }
        return res;
    }
}
