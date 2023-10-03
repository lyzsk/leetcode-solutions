/**
 * @author sichu
 * @date 2023/10/01
 **/
public class Solution {
    public long maximumTripletValue(int[] nums) {
        long curMaxij = 0;
        long curMax = 0;
        long res = 0;
        for (int num : nums) {
            res = Math.max(res, curMaxij * num);
            curMaxij = Math.max(curMaxij, curMax - num);
            curMax = Math.max(curMax, num);
        }
        return res;
    }
}
