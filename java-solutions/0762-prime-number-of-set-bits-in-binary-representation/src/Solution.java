/**
 * @author sichu huang
 * @since 2026/02/20 15:01
 */
public class Solution {
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int x = left; x <= right; ++x) {
            if (((1 << Integer.bitCount(x)) & 665772) != 0) {
                ++res;
            }
        }
        return res;
    }
}
