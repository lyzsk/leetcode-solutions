import java.util.Arrays;

/**
 * @author sichu huang
 * @date 2024/03/15
 **/
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 0);
        int product = 1;
        int zeros = 0;
        for (int num : nums) {
            if (num == 0) {
                zeros++;
                continue;
            }
            product *= num;
        }
        if (zeros == 1) {
            for (int i = 0; i < n; i++) {
                res[i] = nums[i] == 0 ? product : 0;
            }
        } else if (zeros == 0) {
            for (int i = 0; i < n; i++) {
                res[i] = product / nums[i];
            }
        }
        return res;
    }
}
