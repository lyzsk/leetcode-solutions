/**
 * @author sichu
 * @date 2022/12/03
 **/
public class Solution {
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int max, int min) {
        if (root == null) {
            return 0;
        }
        int maxDiff = Math.max(Math.abs(root.val - max), Math.abs(root.val - min));
        max = Math.max(root.val, max);
        min = Math.min(root.val, min);
        maxDiff = Math.max(maxDiff, dfs(root.left, max, min));
        maxDiff = Math.max(maxDiff, dfs(root.right, max, min));
        return maxDiff;
    }
}
