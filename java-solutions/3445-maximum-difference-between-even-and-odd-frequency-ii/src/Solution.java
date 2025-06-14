import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2025/06/12 00:18
 */
public class Solution {
    public int maxDifference(String s, int k) {
        int n = s.length();
        int res = Integer.MIN_VALUE;
        for (char a = '0'; a <= '4'; ++a) {
            for (char b = '0'; b <= '4'; ++b) {
                if (a == b) {
                    continue;
                }
                int[] best = new int[4];
                Arrays.fill(best, Integer.MAX_VALUE);
                int cntA = 0, cntB = 0;
                int prevA = 0, prevB = 0;
                int left = -1;
                for (int right = 0; right < n; ++right) {
                    cntA += (s.charAt(right) == a) ? 1 : 0;
                    cntB += (s.charAt(right) == b) ? 1 : 0;

                    while (right - left >= k && cntB - prevB >= 2) {
                        int left_status = getStatus(prevA, prevB);
                        best[left_status] = Math.min(best[left_status], prevA - prevB);
                        ++left;
                        prevA += (s.charAt(left) == a) ? 1 : 0;
                        prevB += (s.charAt(left) == b) ? 1 : 0;
                    }
                    int rightStatus = getStatus(cntA, cntB);
                    if (best[rightStatus ^ 0b10] != Integer.MAX_VALUE) {
                        res = Math.max(res, cntA - cntB - best[rightStatus ^ 0b10]);
                    }
                }
            }
        }
        return res;
    }

    private int getStatus(int cnt_a, int cnt_b) {
        return ((cnt_a & 1) << 1) | (cnt_b & 1);
    }
}
