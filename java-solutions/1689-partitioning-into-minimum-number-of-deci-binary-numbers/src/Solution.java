/**
 *
 * @author sichu huang
 * @since 2026/03/01 21:10
 */
public class Solution {
    public int minPartitions(String n) {
        int res = 0;
        for (int i = 0; i < n.length(); ++i) {
            res = Math.max(res, n.charAt(i) - '0');
        }
        return res;
    }
}
