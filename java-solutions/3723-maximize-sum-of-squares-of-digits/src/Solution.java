/**
 *
 * @author sichu huang
 * @since 2026/10/14
 */
public class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num) {
            return "";
        }
        int r = sum % 9;
        StringBuilder res = new StringBuilder();
        int nines = sum / 9;
        res.append("9".repeat(Math.max(0, nines)));
        if (r > 0) {
            res.append((char)('0' + r));
        }
        int zeros = num - res.length();
        res.append("0".repeat(Math.max(0, zeros)));
        return res.toString();
    }
}
