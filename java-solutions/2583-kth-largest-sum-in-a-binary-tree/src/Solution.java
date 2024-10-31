import java.util.*;

/**
 * @author sichu huang
 * @since 2024/10/22 18:33
 */
public class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Long> levelSumArray = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<TreeNode> levelNodes = new ArrayList<>(queue);
            long levelSum = 0;
            queue.clear();
            for (TreeNode node : levelNodes) {
                levelSum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            levelSumArray.add(levelSum);
        }
        if (levelSumArray.size() < k) {
            return -1;
        }
        Collections.sort(levelSumArray);
        return levelSumArray.get(levelSumArray.size() - k);
    }
}
