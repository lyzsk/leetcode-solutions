/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 *
 * @author sichu
 * @date 2022/09/02
 **/
public class Solution {
    private int res;

    public int longestUnivaluePath(TreeNode root) {
        this.res = 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftVal = dfs(root.left);
        int rightVal = dfs(root.right);
        int leftRes = 0;
        int rightRes = 0;
        if (root.left != null && root.val == root.left.val) {
            leftRes = leftVal + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            rightRes = rightVal + 1;
        }
        res = Math.max(res, leftRes + rightRes);
        return Math.max(leftRes, rightRes);
    }
}
