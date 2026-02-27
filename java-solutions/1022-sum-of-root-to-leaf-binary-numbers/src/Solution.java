import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu huang
 * @since 2026/02/24 17:39
 */
public class Solution {
    public int sumRootToLeaf(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int val = 0, res = 0;
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                val = (val << 1) | root.val;
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || root.right == prev) {
                if (root.left == null && root.right == null) {
                    res += val;
                }
                val >>= 1;
                stack.pop();
                prev = root;
                root = null;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}
