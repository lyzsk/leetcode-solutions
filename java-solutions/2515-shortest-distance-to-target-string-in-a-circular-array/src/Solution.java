/**
 *
 * @author sichu huang
 * @since 2026/04/16 03:16
 */
public class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int clockwise = (i - startIndex + n) % n;
                int anticlockwise = (startIndex - i + n) % n;
                res = Math.min(res, Math.min(clockwise, anticlockwise));
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
