/**
 * @author sichu
 * @date 2022/11/20
 **/
public class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int maxPosition = 0;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                ++res;
            }
        }
        return res;
    }
}
