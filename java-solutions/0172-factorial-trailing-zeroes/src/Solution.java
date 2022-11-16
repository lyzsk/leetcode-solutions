/**
 * @author sichu
 * @date 2022/11/16
 **/
public class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            n /= 5;
            res += n;
        }
        return res;
    }
}
