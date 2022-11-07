/**
 * @author sichu
 * @date 2022/11/07
 **/
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }

    private boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && helper(p.left, q.right) && helper(p.right, q.left);
    }
}
