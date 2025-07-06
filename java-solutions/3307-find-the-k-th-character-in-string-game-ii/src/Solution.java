/**
 * @author sichu huang
 * @since 2025/07/04 18:58
 */
public class Solution {
    public char kthCharacter(long k, int[] operations) {
        int res = 0;
        int t;
        while (k != 1) {
            t = 63 - Long.numberOfLeadingZeros(k);
            if ((1L << t) == k) {
                t--;
            }
            k = k - (1L << t);
            if (operations[t] != 0) {
                res++;
            }
        }
        return (char)('a' + (res % 26));
    }
}
