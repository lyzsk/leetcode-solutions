/**
 *
 * @author sichu huang
 * @since 2026/07/15 20:21
 */
public class Solution {

    public int gcdOfOddEvenSums(int n) {
        return gcd(n * n, n * (n + 1));
    }

    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
