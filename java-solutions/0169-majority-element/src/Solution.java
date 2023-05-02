import java.util.Arrays;

/**
 * @author sichu
 * @date 2023/05/02
 **/
public class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n / 2];
    }
}
