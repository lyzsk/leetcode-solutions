/**
 * @author sichu huang
 * @date 2024/06/16
 **/
public class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int length = nums.length;
        int idx = 0;
        while (x <= n) {
            if (idx < length && nums[idx] <= x) {
                x += nums[idx];
                ++idx;
            } else {
                x *= 2;
                ++patches;
            }
        }
        return patches;
    }
}
