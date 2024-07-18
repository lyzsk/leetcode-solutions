import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sichu huang
 * @date 2024/07/17
 **/
public class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int val : to_delete) {
            set.add(val);
        }
        List<TreeNode> roots = new ArrayList<>();
        dfs(root, true, set, roots);
        return roots;
    }

    private TreeNode dfs(TreeNode node, boolean isRoot, Set<Integer> set, List<TreeNode> roots) {
        if (node == null) {
            return null;
        }
        boolean deleted = set.contains(node.val);
        node.left = dfs(node.left, deleted, set, roots);
        node.right = dfs(node.right, deleted, set, roots);
        if (deleted) {
            return null;
        } else {
            if (isRoot) {
                roots.add(node);
            }
            return node;
        }
    }
}
