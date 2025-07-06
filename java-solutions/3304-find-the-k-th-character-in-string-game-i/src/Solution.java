/**
 * @author sichu huang
 * @since 2025/07/04 01:20
 */
public class Solution {
    public char kthCharacter(int k) {
        int res = 0;
        int t;
        while (k != 1) {
            t = 31 - Integer.numberOfLeadingZeros(k);
            if ((1 << t) == k) {
                t--;
            }
            k = k - (1 << t);
            res++;
        }
        return (char)('a' + res);
    }
}
