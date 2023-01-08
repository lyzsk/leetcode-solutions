/**
 * > 0 个数,
 * < 0 个数,
 * 边界 left <= right
 *
 * @author sichu
 * @date 2023/01/08
 **/
public class Solution {
    public int maximumCount(int[] nums) {
        int neg = 0;
        int pos = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] < 0) {
                ++neg;
                ++left;
            }
            if (nums[right] > 0) {
                ++pos;
                --right;
            }
            if (nums[left] == 0 && nums[right] == 0) {
                break;
            }
        }
        return Math.max(neg, pos);
    }
}
