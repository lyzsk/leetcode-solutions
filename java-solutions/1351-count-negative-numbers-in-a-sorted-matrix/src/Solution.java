/**
 * @author sichu huang
 * @since 2025/12/28 21:33
 */
public class Solution {
    public int countNegatives(int[][] grid) {
        int num = 0;
        for (int[] row : grid) {
            int l = 0, r = row.length - 1, pos = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (row[mid] < 0) {
                    pos = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (pos != -1) {
                num += row.length - pos;
            }
        }
        return num;
    }
}
