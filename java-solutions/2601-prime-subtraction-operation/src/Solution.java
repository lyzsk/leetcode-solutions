import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2024/11/11 17:14
 */
public class Solution {
    public boolean primeSubOperation(int[] nums) {
        int[] odd = new int[1001];
        Arrays.fill(odd, 1);
        odd[0] = 2;
        odd[1] = 2;
        for (int i = 4; i < 1001; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    odd[i] = 2;
                }
            }
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= nums[i + 1]) {
                int start = nums[i] - nums[i + 1] + 1;
                int max = nums[i];
                if (max <= start) {
                    return false;
                }
                boolean flag = true;
                for (int j = start; j < max; j++) {
                    if (odd[j] == 1) {
                        nums[i] -= j;
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return false;
                }
            }
        }
        return true;
    }
}
