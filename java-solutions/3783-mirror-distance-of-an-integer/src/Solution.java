/**
 *
 * @author sichu huang
 * @since 2026/04/18 08:56
 */
public class Solution {

    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

    private int reverse(int n) {
        int res = 0;
        while (n > 0) {
            res = res * 10 + n % 10;
            n /= 10;
        }
        return res;
    }
}
