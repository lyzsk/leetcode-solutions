/**
 * @author sichu huang
 * @date 2024/04/14
 **/
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return root == null ? 0 : dfs(root);
    }

    private int dfs(TreeNode root) {
        int res = 0;
        if (root.left != null) {
            res += isLeafNode(root.left) ? root.left.val : dfs(root.left);
        }
        if (root.right != null && !isLeafNode(root.right)) {
            res += dfs(root.right);
        }
        return res;
    }

    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
