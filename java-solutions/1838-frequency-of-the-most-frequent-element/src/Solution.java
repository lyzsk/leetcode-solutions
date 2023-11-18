import java.util.Arrays;

/**
 * @author sichu
 * @date 2023/11/18
 **/
public class Solution {
    public int maxFrequency(int[] nums, int k) {
        int res = 0;
        long sum = 0;
        Arrays.sort(nums);
        for (int left = 0, right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum + k < (long)nums[right] * (right - left + 1)) {
                sum -= nums[left++];
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
