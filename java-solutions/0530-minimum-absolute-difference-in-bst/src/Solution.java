/**
 * @author sichu
 * @date 2023/02/03
 **/
public class Solution {
    private int pre;
    private int res;

    public int getMinimumDifference(TreeNode root) {
        this.res = Integer.MAX_VALUE;
        this.pre = -1;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            res = Math.min(res, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
