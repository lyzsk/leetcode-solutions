import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sichu huang
 * @since 2026/01/06 23:45
 */
public class Solution {
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        int res = 1;
        int curr = 1;
        while (!q.isEmpty()) {
            int c = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.remove();
                c += temp.val;
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            if (c > max) {
                max = c;
                res = curr;
            }
            curr += 1;
        }
        return res;
    }
}
