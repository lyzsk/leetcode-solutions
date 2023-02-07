import java.util.Arrays;

/**
 * @author sichu
 * @date 2023/02/07
 **/
public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2) {
            res += nums[i];
        }
        return res;
    }
}
