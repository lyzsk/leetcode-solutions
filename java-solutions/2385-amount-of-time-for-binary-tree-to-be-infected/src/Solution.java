import java.util.*;

/**
 * @author sichu
 * @date 2024/01/10
 **/
public class Solution {
    private Map<Integer, List<Integer>> adjList = new HashMap<>(16);

    public int amountOfTime(TreeNode root, int start) {
        convertToGraph(root);
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.addLast(start);
        int time = -1;
        while (!queue.isEmpty()) {
            ++time;
            for (int i = queue.size(); i > 0; i--) {
                int curNode = queue.pollFirst();
                visited.add(curNode);
                if (adjList.containsKey(curNode)) {
                    for (Integer neighbor : adjList.get(curNode)) {
                        if (!visited.contains(neighbor)) {
                            queue.addLast(neighbor);
                        }
                    }
                }
            }
        }
        return time;
    }

    private void convertToGraph(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            adjList.computeIfAbsent(root.val, v -> new ArrayList<>()).add(root.left.val);
            adjList.computeIfAbsent(root.left.val, v -> new ArrayList<>()).add(root.val);
        }
        if (root.right != null) {
            adjList.computeIfAbsent(root.val, v -> new ArrayList<>()).add(root.right.val);
            adjList.computeIfAbsent(root.right.val, v -> new ArrayList<>()).add(root.val);
        }
        convertToGraph(root.left);
        convertToGraph(root.right);
    }
}
