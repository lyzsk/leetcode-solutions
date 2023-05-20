/**
 * @author sichu
 * @date 2023/05/20
 **/
public class Solution {
    private int res = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int x = root.val;
        if (x <= left[1] || x >= right[0]) {
            return new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        }
        int sum = left[2] + right[2] + x;
        res = Math.max(res, sum);
        return new int[] {Math.min(left[0], x), Math.max(right[1], x), sum};
    }
}
