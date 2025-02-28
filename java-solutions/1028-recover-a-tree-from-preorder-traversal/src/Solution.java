import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu huang
 * @since 2025/02/22 18:50
 */
public class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Deque<TreeNode> path = new ArrayDeque<>();
        int pos = 0;
        while (pos < traversal.length()) {
            int level = 0;
            while (traversal.charAt(pos) == '-') {
                ++level;
                ++pos;
            }
            int value = 0;
            while (pos < traversal.length() && Character.isDigit(traversal.charAt(pos))) {
                value = value * 10 + (traversal.charAt(pos) - '0');
                ++pos;
            }
            TreeNode node = new TreeNode(value);
            if (level == path.size()) {
                if (!path.isEmpty()) {
                    path.peek().left = node;
                }
            } else {
                while (level != path.size()) {
                    path.pop();
                }
                path.peek().right = node;
            }
            path.push(node);
        }
        while (path.size() > 1) {
            path.pop();
        }
        return path.peek();
    }
}
