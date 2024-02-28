/**
 * @author sichu
 * @date 2024/02/28
 **/
public class Solution {
    private int curVal = 0;
    private int curHeight = 0;

    public int findBottomLeftValue(TreeNode root) {
        int curHeight = 0;
        dfs(root, 0);
        return curVal;
    }

    private void dfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        ++height;
        dfs(root.left, height);
        dfs(root.right, height);
        if (height > curHeight) {
            curHeight = height;
            curVal = root.val;
        }
    }
}
