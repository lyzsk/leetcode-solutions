/**
 *
 * @author sichu huang
 * @since 2026/08/18
 */
public class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] freq = new int[51];
        int maxEle = Integer.MIN_VALUE;
        int n = nums.length;

        for (int num : nums) {
            freq[num]++;
            maxEle = Math.max(maxEle, num);
        }

        if (k == 1) {
            for (int i = 50; i >= 0; i--) {
                if (freq[i] == 1)
                    return i;
            }
        } else if (k == n) {
            return maxEle;
        } else {
            if (freq[nums[0]] == 1 && freq[nums[n - 1]] == 1)
                return Math.max(nums[0], nums[n - 1]);
            else if (freq[nums[0]] == 1)
                return nums[0];
            else if (freq[nums[n - 1]] == 1)
                return nums[n - 1];
        }
        return -1;
    }
}
