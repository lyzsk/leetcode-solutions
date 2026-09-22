import java.util.Arrays;

/**
 *
 * @author sichu huang
 * @since 2026/09/22
 */
public class Solution {
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        SegmentTree seg = new SegmentTree(nums, k);
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int index = q[0];
            int value = q[1];
            int start = q[2];
            int x = q[3];

            seg.update(1, 0, n - 1, index, value);
            int[] pre = seg.query(1, 0, n - 1, start, n - 1);
            ans[i] = pre[x];
        }

        return ans;
    }
}

class SegmentTree {
    private static final int MAXK = 6;
    private int k;
    private int n;
    private int[][] tree;

    public SegmentTree(int[] nums, int k) {
        this.k = k;
        this.n = nums.length;
        int size = 2 << (Integer.toBinaryString(n).length());
        tree = new int[size][MAXK];
        build(nums, 1, 0, n - 1);
    }

    private void makeLeaf(int o, int value) {
        Arrays.fill(tree[o], 0);
        int r = value % k;
        tree[o][r] = 1;
        tree[o][k] = r;
    }

    private void mergePre(int[] left, int[] right, int[] result) {
        int mulL = left[k];
        int mulR = right[k];
        result[k] = (mulL * mulR) % k;

        System.arraycopy(left, 0, result, 0, k);
        for (int x = 0; x < k; x++) {
            result[(mulL * x) % k] += right[x];
        }
    }

    private void maintain(int o) {
        mergePre(tree[o * 2], tree[o * 2 + 1], tree[o]);
    }

    private void build(int[] nums, int o, int l, int r) {
        if (l == r) {
            makeLeaf(o, nums[l]);
            return;
        }
        int m = (l + r) / 2;
        build(nums, o * 2, l, m);
        build(nums, o * 2 + 1, m + 1, r);
        maintain(o);
    }

    public void update(int o, int l, int r, int index, int value) {
        if (l == r) {
            makeLeaf(o, value);
            return;
        }
        int m = (l + r) / 2;
        if (index <= m) {
            update(o * 2, l, m, index, value);
        } else {
            update(o * 2 + 1, m + 1, r, index, value);
        }
        maintain(o);
    }

    public int[] query(int o, int l, int r, int L, int R) {
        if (L <= l && r <= R) {
            return tree[o];
        }

        int m = (l + r) / 2;
        if (R <= m) {
            return query(o * 2, l, m, L, R);
        }
        if (L > m) {
            return query(o * 2 + 1, m + 1, r, L, R);
        }

        int[] left = query(o * 2, l, m, L, R);
        int[] right = query(o * 2 + 1, m + 1, r, L, R);
        int[] result = new int[MAXK];
        mergePre(left, right, result);
        return result;
    }
}