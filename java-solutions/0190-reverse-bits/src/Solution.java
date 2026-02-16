/**
 * @author sichu huang
 * @since 2026/02/16 13:04
 */
public class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            res |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return res;
    }
}
