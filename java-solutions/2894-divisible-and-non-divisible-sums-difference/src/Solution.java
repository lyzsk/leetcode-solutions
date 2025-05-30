/**
 * @author sichu huang
 * @since 2025/05/27 21:13
 */
public class Solution {
    public int differenceOfSums(int n, int m) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                res -= i;
            } else {
                res += i;
            }
        }
        return res;
    }
}
