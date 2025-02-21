import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2025/02/21 12:16
 */
public class FindElements {

    private Set<Integer> valSet;

    public FindElements(TreeNode root) {
        this.valSet = new HashSet<>();
        dfs(root, 0);
    }

    public boolean find(int target) {
        return valSet.contains(target);
    }

    private void dfs(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        node.val = val;
        valSet.add(val);
        dfs(node.left, val * 2 + 1);
        dfs(node.right, val * 2 + 2);
    }
}
