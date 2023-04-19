/**
 * @author sichu
 * @date 2023/04/19
 **/
public class Solution {
    private int res = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, 0, 0);
        return res;
    }

    private void dfs(TreeNode root, int leftMax, int rightMax) {
        res = Math.max(res, Math.max(leftMax, rightMax));
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, rightMax + 1, 0);
        }
        if (root.right != null) {
            dfs(root.right, 0, leftMax + 1);
        }
    }
}
