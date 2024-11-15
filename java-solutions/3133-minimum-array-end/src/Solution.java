/**
 * @author sichu huang
 * @since 2024/11/09 17:41
 */
public class Solution {
    public long minEnd(int n, int x) {
        int bitCount = 128 - Long.numberOfLeadingZeros(n) - Long.numberOfLeadingZeros(x);
        long res = x;
        long m = n - 1;
        int j = 0;
        for (int i = 0; i < bitCount; ++i) {
            if (((res >> i) & 1) == 0) {
                if (((m >> j) & 1) == 1) {
                    res |= (1L << i);
                }
                j++;
            }
        }
        return res;
    }
}
