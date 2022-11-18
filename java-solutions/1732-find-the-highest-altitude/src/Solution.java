/**
 * @author sichu
 * @date 2022/11/18
 **/
public class Solution {
    public int largestAltitude(int[] gain) {
        int res = 0;
        int presum = 0;
        for (int x : gain) {
            presum += x;
            res = Math.max(res, presum);
        }
        return res;
    }
}
