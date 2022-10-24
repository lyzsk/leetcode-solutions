/**
 * @author sichu
 * @date 2022/10/24
 **/
public class Solution {
    public int partitionDisjoint(int[] nums) {
        int leftMax = nums[0];
        int leftPos = 0;
        int curMax = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = curMax;
                leftPos = i;
            }
        }
        return leftPos + 1;
    }
}
