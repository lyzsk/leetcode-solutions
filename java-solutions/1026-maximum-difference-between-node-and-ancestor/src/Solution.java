/**
 * @author sichu
 * @date 2022/12/03
 **/
public class Solution {
    private int res = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val, root.val);
        return res;
    }

    private void dfs(TreeNode root, int max, int min) {
        if (root == null) {
            return;
        }
        max = Math.max(root.val, max);
        min = Math.min(root.val, min);
        if (root.left == null && root.right == null) {
            res = Math.max(res, Math.abs(max - min));
        }
        dfs(root.left, max, min);
        dfs(root.right, max, min);
    }
}
