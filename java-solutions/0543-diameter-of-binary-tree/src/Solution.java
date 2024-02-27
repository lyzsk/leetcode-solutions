/**
 * @author sichu
 * @date 2024/02/27
 **/
public class Solution {

    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(left + right, res);
        return Math.max(left, right) + 1;
    }

}
