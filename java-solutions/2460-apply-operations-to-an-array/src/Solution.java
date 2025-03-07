/**
 * @author sichu huang
 * @since 2025/03/01 13:19
 */
public class Solution {
    public int[] applyOperations(int[] nums) {
        int[] res = new int[nums.length];
        int cnt = 0;
        int i;
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] != 0) {
                if (nums[i] == nums[i + 1]) {
                    res[cnt] = nums[i] * 2;
                    i++;
                } else {
                    res[cnt] = nums[i];
                }
                cnt++;
            }
        }
        if (i != nums.length) {
            res[cnt] = nums[nums.length - 1];
        }
        return res;
    }
}
