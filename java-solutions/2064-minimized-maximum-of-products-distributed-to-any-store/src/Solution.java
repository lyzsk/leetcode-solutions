/**
 * @author sichu huang
 * @since 2024/11/14 15:16
 */
public class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int max = 0;
        for (int q : quantities) {
            max = Math.max(max, q);
        }
        int l = 1, r = max;
        while (l <= r) {
            int mid = l + (r - l >> 1);
            int cr = check(n, mid, quantities);
            if (cr >= 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int check(int n, int mid, int[] quantities) {
        for (int quantity : quantities) {
            n -= (quantity + mid - 1) / mid;
        }
        return n;
    }
}
