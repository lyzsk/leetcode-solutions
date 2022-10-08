import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/10/08
 **/
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int min = nums[i] + nums[left] + nums[left + 1];
                if (target < min) {
                    if (Math.abs(res - target) > Math.abs(min - target)) {
                        res = min;
                    }
                    break;
                }
                int max = nums[i] + nums[right] + nums[right - 1];
                if (target > max) {
                    if (Math.abs(res - target) > Math.abs(max - target)) {
                        res = max;
                    }
                    break;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(res - target) > Math.abs(sum - target)) {
                    res = sum;
                }
                if (sum > target) {
                    --right;
                    while (left < right && nums[right] == nums[right + 1]) {
                        --right;
                    }
                } else {
                    ++left;
                    while (left < right && nums[left] == nums[left - 1]) {
                        ++left;
                    }
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
        return res;
    }
}
