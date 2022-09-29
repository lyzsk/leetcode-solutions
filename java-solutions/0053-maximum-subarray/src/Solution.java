/**
 * @author sichu
 * @date 2022/09/29
 **/
public class Solution {
    public int maxSubArray(int[] nums) {
        int presum = 0;
        int minpre = 0;
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            presum += num;
            res = Math.max(res, presum - minpre);
            minpre = Math.min(minpre, presum);
        }
        return res;
    }
}
