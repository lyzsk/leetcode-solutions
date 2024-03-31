/**
 * @author sichu huang
 * @date 2024/03/31
 **/
public class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int minKidx = -1;
        int maxKidx = -1;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x == minK) {
                minKidx = i;
            }
            if (x == maxK) {
                maxKidx = i;
            }
            if (x < minK || x > maxK) {
                idx = i;
            }
            res += Math.max(Math.min(minKidx, maxKidx) - idx, 0);
        }
        return res;
    }
}
