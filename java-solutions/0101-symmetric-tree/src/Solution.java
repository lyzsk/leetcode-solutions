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
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return helper(p.left, q.right) && helper(p.right, q.left);
        }
    }
}
