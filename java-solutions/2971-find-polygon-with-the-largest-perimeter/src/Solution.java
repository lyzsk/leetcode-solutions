import java.util.Arrays;

/**
 * @author sichu
 * @date 2024/02/15
 **/
public class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int n = nums.length;
        for (int i = n - 1; i >= 2; i--) {
            if (sum - nums[i] > nums[i]) {
                return sum;
            }
            sum -= nums[i];
        }
        return -1;
    }
}
