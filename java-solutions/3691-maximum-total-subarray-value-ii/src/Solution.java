import java.util.PriorityQueue;

/**
 *
 * @author sichu huang
 * @since 2026/06/10 19:00
 */
public class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int logn = 32 - Integer.numberOfLeadingZeros(n);
        int[][] stMax = new int[n][logn];
        int[][] stMin = new int[n][logn];
        for (int i = 0; i < n; i++) {
            stMax[i][0] = stMin[i][0] = nums[i];
        }
        for (int j = 1; j < logn; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                stMax[i][j] = Math.max(stMax[i][j - 1], stMax[i + (1 << (j - 1))][j - 1]);
                stMin[i][j] = Math.min(stMin[i][j - 1], stMin[i + (1 << (j - 1))][j - 1]);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int l = 0; l < n; l++) {
            int j = 31 - Integer.numberOfLeadingZeros(n - 1 - l + 1);
            int mx = Math.max(stMax[l][j], stMax[n - 1 - (1 << j) + 1][j]);
            int mn = Math.min(stMin[l][j], stMin[n - 1 - (1 << j) + 1][j]);
            pq.offer(new int[] {mx - mn, l, n - 1});
        }
        long res = 0;
        while (k-- > 0) {
            int[] top = pq.poll();
            res += top[0];
            int l = top[1], r = top[2];
            if (r > l) {
                int j = 31 - Integer.numberOfLeadingZeros(r - 1 - l + 1);
                int mx = Math.max(stMax[l][j], stMax[r - 1 - (1 << j) + 1][j]);
                int mn = Math.min(stMin[l][j], stMin[r - 1 - (1 << j) + 1][j]);
                pq.offer(new int[] {mx - mn, l, r - 1});
            }
        }
        return res;
    }
}
