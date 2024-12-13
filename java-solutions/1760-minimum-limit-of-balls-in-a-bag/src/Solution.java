import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2024/12/07 15:46
 */
public class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        int res = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            int ops = 0;
            for (int n : nums) {
                ops += (n - 1) / mid;
                if (ops > maxOperations) {
                    break;
                }
            }
            if (ops <= maxOperations) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
