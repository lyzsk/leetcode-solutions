/**
 * @author sichu huang
 * @since 2025/03/09 13:46
 */
public class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int res = 0, cnt = 1;
        for (int i = -k + 2; i < n; i++) {
            if (colors[(i + n) % n] != colors[(i - 1 + n) % n]) {
                cnt += 1;
            } else {
                cnt = 1;
            }
            if (cnt >= k) {
                res += 1;
            }
        }
        return res;
    }
}
