/**
 * @author sichu
 * @date 2023/08/08
 **/
public class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int presum = 0;
        int maxpre = 0;
        int minpre = 0;
        for (int num : nums) {
            presum += num;
            maxpre = Math.max(maxpre, presum);
            minpre = Math.min(minpre, presum);
        }
        return maxpre - minpre;
    }
}
