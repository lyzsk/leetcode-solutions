import java.util.*;

/**
 * @author sichu huang
 * @since 2024/12/23 17:25
 */
public class Solution {
    public int minimumOperations(TreeNode root) {
        int operations = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] arr = new int[size];
            int[] sorted = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                arr[i] = node.val;
                sorted[i] = node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            Arrays.sort(sorted);
            Map<Integer, Integer> targetIndices = new HashMap<>();
            for (int i = 0; i < size; i++) {
                targetIndices.put(sorted[i], i);
            }
            for (int i = 0; i < size; i++) {
                while (arr[i] != sorted[i]) {
                    int targetIndex = targetIndices.get(arr[i]);
                    swap(arr, i, targetIndex);
                    operations++;
                }
            }
        }
        return operations;
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
