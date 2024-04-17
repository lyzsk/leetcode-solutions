/**
 * @author sichu huang
 * @date 2024/04/17
 **/
public class Solution {
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, new StringBuilder(), sb);
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder path, StringBuilder sb) {
        if (root == null) {
            return;
        }
        path.append((char)('a' + root.val));
        if (root.left == null && root.right == null) {
            String str = path.reverse().toString();
            if (sb.length() == 0 || str.compareTo(sb.toString()) < 0) {
                sb.setLength(0);
                sb.append(str);
            }
            path.reverse();
        }
        dfs(root.left, path, sb);
        dfs(root.right, path, sb);
        path.setLength(path.length() - 1);
    }
}
