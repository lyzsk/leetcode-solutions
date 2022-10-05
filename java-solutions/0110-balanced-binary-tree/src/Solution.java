/**
 * @author sichu
 * @date 2022/10/05
 **/
public class Solution {
    private static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) >= 0;
    }
}
