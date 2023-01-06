/**
 * @author sichu
 * @date 2023/01/06
 **/
public class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        if (n == 1) {
            return x == nums[0] ? 1 : -1;
        }
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        long target = sum - x;
        if (target == 0) {
            return n;
        }
        int res = -1;
        int left = 0;
        int right = 0;
        long cur = 0;
        while (right < n) {
            cur += nums[right];
            while (left < right && cur > target) {
                cur -= nums[left++];
            }
            if (cur == target) {
                res = Math.max(res, right - left + 1);
            }
            ++right;
        }
        return res == -1 ? -1 : n - res;
    }
}
