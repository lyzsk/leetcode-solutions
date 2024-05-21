/**
 * @author sichu huang
 * @date 2024/05/20
 **/
public class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }

    private int helper(int[] nums, int level, int current) {
        if (level == nums.length) {
            return current;
        }
        int include = helper(nums, level + 1, current ^ nums[level]);
        int exclude = helper(nums, level + 1, current);
        return include + exclude;
    }
}
