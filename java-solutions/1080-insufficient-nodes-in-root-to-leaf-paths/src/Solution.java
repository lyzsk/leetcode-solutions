/**
 * @author sichu
 * @date 2023/05/22
 **/
public class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean flag = check(root, 0, limit);
        return flag ? root : null;
    }

    private boolean check(TreeNode root, int sum, int limit) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val + sum >= limit;
        }
        boolean leftFlag = check(root.left, root.val + sum, limit);
        boolean rightFlag = check(root.right, root.val + sum, limit);
        if (!leftFlag) {
            root.left = null;
        }
        if (!rightFlag) {
            root.right = null;
        }
        return leftFlag || rightFlag;
    }
}
