/**
 * @author sichu
 * @date 2023/05/10
 **/
public class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int res = 1;
        int resid = 1 % k;
        while (resid != 0) {
            resid = (resid * 10 + 1) % k;
            ++res;
        }
        return res;
    }
}
