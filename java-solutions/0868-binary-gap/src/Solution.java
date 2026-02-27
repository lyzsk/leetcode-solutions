/**
 * @author sichu huang
 * @since 2026/02/22 21:54
 */
public class Solution {
    public int binaryGap(int n) {
        int last = -1, res = 0;
        for (int i = 0; n != 0; ++i) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    res = Math.max(res, i - last);
                }
                last = i;
            }
            n >>= 1;
        }
        return res;
    }
}
