/**
 * @author sichu huang
 * @since 2025/03/05 17:31
 */
public class Solution {
    public long coloredCells(int n) {
        return 1 + 4L * n * (n - 1) / 2;
    }
}
