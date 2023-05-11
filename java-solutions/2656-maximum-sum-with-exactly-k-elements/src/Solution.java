/**
 * @author sichu
 * @date 2023/05/11
 **/
public class Solution {
    public int maximizeSum(int[] nums, int k) {
        int maxv = 0;
        for (int num : nums) {
            maxv = Math.max(maxv, num);
        }
        return (maxv + maxv + k - 1) * k / 2;
    }
}
