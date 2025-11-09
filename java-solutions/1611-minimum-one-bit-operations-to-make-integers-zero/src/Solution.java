/**
 * @author sichu huang
 * @since 2025/11/08 13:12
 */
public class Solution {
    public int minimumOneBitOperations(int n) {
        int res = 0;
        int sign = 1;
        for (int i = 29; i >= 0; --i) {
            if ((n & (1 << i)) != 0) {
                res += sign * ((1 << (i + 1)) - 1);
                sign = -sign;
            }
        }
        return res;
    }
}
