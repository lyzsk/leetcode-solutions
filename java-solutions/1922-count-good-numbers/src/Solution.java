/**
 * @author sichu huang
 * @since 2025/04/13 13:07
 */
public class Solution {
    private final long mod = (long)(1e9 + 7);

    public int countGoodNumbers(long n) {
        return (int)(quickmul(5, (n + 1) / 2) * quickmul(4, n / 2) % mod);
    }

    private long quickmul(int x, long y) {
        long res = 1;
        long mul = x;
        while (y > 0) {
            if (y % 2 == 1) {
                res = res * mul % mod;
            }
            mul = mul * mul % mod;
            y /= 2;
        }
        return res;
    }
}
