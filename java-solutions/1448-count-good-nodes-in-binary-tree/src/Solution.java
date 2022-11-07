/**
 * @author sichu
 * @date 2022/11/07
 **/
public class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int res = root.val >= max ? 1 : 0;
        max = Math.max(max, root.val);
        res += dfs(root.left, max);
        res += dfs(root.right, max);
        return res;
    }
}
