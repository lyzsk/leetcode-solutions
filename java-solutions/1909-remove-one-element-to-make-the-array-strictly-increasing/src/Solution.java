/**
 * @author sichu
 * @date 2022/11/22
 **/
public class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int last = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] <= last) {
                ++cnt;
                if (i > 1 && nums[i] <= nums[i - 2]) {
                    last = nums[i - 1];
                    continue;
                }
            }
            last = nums[i];
        }
        return cnt <= 1;
    }
}
