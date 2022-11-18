import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/11/17
 **/
public class Solution {
    public int longestConsecutive(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        // for (int num : nums) {
        //     set.add(num);
        // }
        // int res = 0;
        // for (int num : nums) {
        //     if (set.contains(num - 1)) {
        //         continue;
        //     }
        //     int temp = num;
        //     while (set.contains(temp)) {
        //         ++temp;
        //     }
        //     res = Math.max(res, temp - num);
        // }
        // return res;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 1;
        if (nums.length == 1) {
            return res;
        }
        Arrays.sort(nums);
        int temp = res;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] == nums[i - 1] + 1) {
                ++temp;
            } else {
                res = Math.max(res, temp);
                temp = 1;
            }
        }
        return Math.max(res, temp);
    }
}
