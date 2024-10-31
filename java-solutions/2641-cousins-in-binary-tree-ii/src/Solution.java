import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu huang
 * @since 2024/10/23 17:13
 */
public class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        root.val = 0;
        while (!queue.isEmpty()) {
            Deque<TreeNode> queue2 = new ArrayDeque<>();
            int sum = 0;
            for (TreeNode fa : queue) {
                if (fa.left != null) {
                    queue2.offer(fa.left);
                    sum += fa.left.val;
                }
                if (fa.right != null) {
                    queue2.offer(fa.right);
                    sum += fa.right.val;
                }
            }
            for (TreeNode fa : queue) {
                int childSum =
                    (fa.left != null ? fa.left.val : 0) + (fa.right != null ? fa.right.val : 0);
                if (fa.left != null) {
                    fa.left.val = sum - childSum;
                }
                if (fa.right != null) {
                    fa.right.val = sum - childSum;
                }
            }
            queue = queue2;
        }
        return root;
    }
}
