/**
 * @author sichu huang
 * @since 2025/12/31 15:17
 */
public class Solution {
    public int minNonZeroProduct(int p) {
        if (p == 1) {
            return 1;
        }
        long mod = (long)(1e9 + 7);
        long x = fastPow(2, p, mod) - 1;
        long y = (long)1 << (p - 1);
        return (int)(fastPow(x - 1, y - 1, mod) * x % mod);
    }

    private long fastPow(long x, long n, long mod) {
        long res = 1;
        for (; n != 0; n >>= 1) {
            if ((n & 1) != 0) {
                res = res * x % mod;
            }
            x = x * x % mod;
        }
        return res;
    }
}
