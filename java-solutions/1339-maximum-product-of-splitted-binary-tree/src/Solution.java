import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sichu huang
 * @since 2026/01/08 00:43
 */
public class Solution {
    long MOD = (long)(1e9 + 7);
    long res = 0;

    public int maxProduct(TreeNode root) {
        long total = dfs(root);
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                continue;
            }
            long cur = (total - node.val) * node.val;
            res = Math.max(res, cur);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return (int)(res % MOD);
    }

    private long dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        node.val += (int)(dfs(node.left) + dfs(node.right));
        return node.val;
    }
}
