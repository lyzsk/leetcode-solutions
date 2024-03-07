import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/11/17
 **/
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int res = 1;
        if (n == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int temp = res;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                ++temp;
            } else {
                res = Math.max(res, temp);
                temp = 1;
            }
        }
        return Math.max(res, temp);
    }
}
