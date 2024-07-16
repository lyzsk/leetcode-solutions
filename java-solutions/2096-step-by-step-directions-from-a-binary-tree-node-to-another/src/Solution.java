/**
 * @author sichu huang
 * @date 2024/07/16
 **/
public class Solution {
    StringBuilder sb = new StringBuilder();
    StringBuilder start = new StringBuilder();
    StringBuilder dest = new StringBuilder();

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode ancestor = findRoot(root, startValue, destValue);
        dfsStart(ancestor, startValue);
        dfsDest(ancestor, destValue);
        return sb.toString();
    }

    private void dfsDest(TreeNode root, int destValue) {
        if (root == null) {
            return;
        }
        if (root.val == destValue) {
            sb.append(dest);
            return;
        }
        dest.append("L");
        dfsDest(root.left, destValue);
        dest.deleteCharAt(dest.length() - 1);
        dest.append("R");
        dfsDest(root.right, destValue);
        dest.deleteCharAt(dest.length() - 1);
    }

    private void dfsStart(TreeNode root, int startValue) {
        if (root == null) {
            return;
        }
        if (root.val == startValue) {
            sb.append(start);
            return;
        }
        start.append("U");
        dfsStart(root.left, startValue);
        start.deleteCharAt(start.length() - 1);
        start.append("U");
        dfsStart(root.right, startValue);
        start.deleteCharAt(start.length() - 1);
    }

    private TreeNode findRoot(TreeNode root, int startValue, int destValue) {
        if (root == null || root.val == startValue || root.val == destValue) {
            return root;
        }
        TreeNode left = findRoot(root.left, startValue, destValue);
        TreeNode right = findRoot(root.right, startValue, destValue);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
