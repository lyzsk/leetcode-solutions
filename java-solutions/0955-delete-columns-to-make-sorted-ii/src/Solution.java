/**
 * @author sichu huang
 * @since 2025/12/21 13:50
 */
public class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        char[][] a = new char[n][];
        for (int i = 0; i < n; i++) {
            a[i] = strs[i].toCharArray();
        }
        boolean[] resolved = new boolean[n - 1];
        int unresolved = n - 1;
        int deletions = 0;
        for (int col = 0; col < m && unresolved > 0; col++) {
            boolean needDelete = false;
            for (int row = 0; row < n - 1; row++) {
                if (!resolved[row] && a[row][col] > a[row + 1][col]) {
                    needDelete = true;
                    break;
                }
            }
            if (needDelete) {
                deletions++;
                continue;
            }
            for (int row = 0; row < n - 1; row++) {
                if (!resolved[row] && a[row][col] < a[row + 1][col]) {
                    resolved[row] = true;
                    unresolved--;
                }
            }
        }
        return deletions;
    }
}
