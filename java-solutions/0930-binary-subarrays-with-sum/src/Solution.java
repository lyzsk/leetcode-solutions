/**
 * @author sichu huang
 * @date 2024/03/14
 **/
public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int i = 0;
        int count = 0;
        int res = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 1) {
                --goal;
                count = 0;
            }
            while (goal == 0 && i <= j) {
                goal += nums[i];
                ++i;
                ++count;
                if (i > j - goal + 1) {
                    break;
                }
            }
            while (goal < 0) {
                goal += nums[i];
                ++i;
            }
            res += count;
        }
        return res;
    }
}
