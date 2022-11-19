/**
 * @author sichu
 * @date 2022/11/19
 **/
public class Solution {
    public int minDeletion(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1] && (i + res) % 2 == 0) {
                ++res;
            }
        }
        if ((n - res) % 2 != 0) {
            ++res;
        }
        return res;
    }
}
