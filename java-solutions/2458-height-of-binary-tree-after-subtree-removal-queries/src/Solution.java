import java.util.*;

/**
 * @author sichu huang
 * @since 2024/10/26 12:37
 */
public class Solution {
    Map<Integer, Integer> height = new HashMap<>();
    Map<Integer, Integer> valToAns = new HashMap<>();

    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        getLength(root);
        Deque<TreeNode> q = new ArrayDeque<>();
        List<Integer> vals = new ArrayList<>();
        q.add(root);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int maxv = 0, maxv2 = -1;
            for (int i = 1; i <= size; i++) {
                TreeNode p = q.poll();
                vals.add(p.val);
                if (height.get(p.val) > maxv) {
                    maxv2 = maxv;
                    maxv = height.get(p.val);
                } else if (height.get(p.val) > maxv2) {
                    maxv2 = height.get(p.val);
                }
                if (p.left != null) {
                    q.add(p.left);
                }
                if (p.right != null) {
                    q.add(p.right);
                }
            }
            for (int i = 0; i < size; i++) {
                int val = vals.get(i);
                if (height.get(val) == maxv) {
                    valToAns.put(val, maxv2 + step);
                } else {
                    valToAns.put(val, maxv + step);
                }
                if (size == 1) {
                    valToAns.put(val, valToAns.get(val) - 1);
                }
            }
            vals.clear();
            step++;
        }
        for (int i = 0; i < n; i++) {
            ans[i] = valToAns.get(queries[i]);
        }
        return ans;
    }

    private int getLength(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int l = getLength(root.left);
        int r = getLength(root.right);
        int len = Math.max(l, r) + 1;
        height.put(root.val, len);
        return len;
    }
}
