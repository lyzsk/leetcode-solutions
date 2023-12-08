/**
 * @author sichu
 * @date 2023/12/08
 **/
public class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            return;
        }
        sb.append('(');
        dfs(root.left, sb);
        sb.append(')');
        if (root.right != null) {
            sb.append('(');
            dfs(root.right, sb);
            sb.append(')');
        }
    }
}
