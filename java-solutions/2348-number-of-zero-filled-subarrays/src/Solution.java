/**
 * @author sichu
 * @date 2023/04/21
 **/
public class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0L;
        int zeroCnt = 0;
        for (int num : nums) {
            if (num == 0) {
                ++zeroCnt;
                res += zeroCnt;
            } else {
                zeroCnt = 0;
            }
        }
        return res;
    }
}
