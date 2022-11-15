/**
 * @author sichu
 * @date 2022/11/15
 **/
public class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        if (n > 1) {
            for (int i = 1; i < n; i++) {
                res = res ^ nums[i];
            }
        }
        return res;
    }
}
