/**
 * @author sichu huang
 * @date 2024/05/18
 **/
public class Solution {
    private int moves = 0;

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left_excess = dfs(node.left);
        int right_excess = dfs(node.right);
        moves += Math.abs(left_excess) + Math.abs(right_excess);
        return node.val + left_excess + right_excess - 1;
    }

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }
}
