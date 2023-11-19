import java.util.Arrays;

/**
 * @author sichu
 * @date 2023/11/19
 **/
public class Solution {
    public int reductionOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 0;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] != nums[i]) {
                res += n - i;
            }
        }
        return res;
    }
}
