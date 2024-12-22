/**
 * @author sichu huang
 * @since 2024/12/22 13:17
 */
public class Solution {
    private int[] zd;

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        zd = new int[n * 4];
        build(1, n, 1, heights);

        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }

            if (a == b || heights[a] < heights[b]) {
                ans[i] = b;
                continue;
            }

            ans[i] = query(b + 1, heights[a], 1, n, 1) - 1;
        }
        return ans;
    }

    private void build(int l, int r, int rt, int[] heights) {
        if (l == r) {
            zd[rt] = heights[l - 1];
            return;
        }

        int mid = (l + r) >> 1;
        build(l, mid, rt << 1, heights);
        build(mid + 1, r, rt << 1 | 1, heights);
        zd[rt] = Math.max(zd[rt << 1], zd[rt << 1 | 1]);
    }

    private int query(int pos, int val, int l, int r, int rt) {
        if (val >= zd[rt]) {
            return 0;
        }

        if (l == r) {
            return l;
        }

        int mid = (l + r) >> 1;
        if (pos <= mid) {
            int res = query(pos, val, l, mid, rt << 1);
            if (res != 0) {
                return res;
            }
        }
        return query(pos, val, mid + 1, r, rt << 1 | 1);
    }
}
