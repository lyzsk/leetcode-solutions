/**
 * @author sichu huang
 * @since 2024/12/20 15:37
 */
public class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, true);
        return root;
    }

    private void dfs(TreeNode root1, TreeNode root2, boolean isOdd) {
        if (root1 == null) {
            return;
        }
        if (isOdd) {
            int temp = root1.val;
            root1.val = root2.val;
            root2.val = temp;
        }
        dfs(root1.left, root2.right, !isOdd);
        dfs(root1.right, root2.left, !isOdd);
    }
}
