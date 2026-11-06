import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author sichu huang
 * @since 2026/11/06
 */
public class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, Comparator.comparingInt(o -> o[1]));

        int m = queries.length;
        Integer[] ids = new Integer[m];
        for (int i = 0; i < m; i++)
            ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> queries[o]));

        int[] res = new int[m];
        int[] cnt = new int[n + 1];
        int left = 0, right = 0, active = 0;

        for (int i : ids) {
            int q = queries[i];
            while (right < logs.length && logs[right][1] <= q) {
                int id = logs[right++][0];
                if (cnt[id]++ == 0) {
                    ++active;
                }
            }
            while (left < right && logs[left][1] < q - x) {
                int id = logs[left++][0];
                if (--cnt[id] == 0) {
                    --active;
                }
            }
            res[i] = n - active;
        }
        return res;
    }
}
