import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sichu huang
 * @since 2025/10/09 07:16
 */
public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        int[] res = new int[n];
        int[][] idx = new int[n][2];
        for (int i = 0; i < n; ++i) {
            idx[i][0] = spells[i];
            idx[i][1] = i;
        }
        Arrays.sort(potions);
        for (int i = 0, j = m - 1; i < j; ++i, --j) {
            int temp = potions[i];
            potions[i] = potions[j];
            potions[j] = temp;
        }
        Arrays.sort(idx, Comparator.comparingInt(o -> o[0]));
        for (int i = 0, j = 0; i < n; ++i) {
            int p = idx[i][1];
            int v = idx[i][0];
            while (j < m && (long)potions[j] * v >= success) {
                ++j;
            }
            res[p] = j;
        }
        return res;
    }
}
