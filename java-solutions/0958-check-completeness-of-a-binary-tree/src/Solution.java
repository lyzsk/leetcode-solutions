import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @since 2025/12/22 23:52
 */
public class Solution {
    public boolean isCompleteTree(TreeNode root) {
        List<ANode> nodes = new ArrayList();
        nodes.add(new ANode(root, 1));
        int i = 0;
        while (i < nodes.size()) {
            ANode anode = nodes.get(i++);
            if (anode.node != null) {
                nodes.add(new ANode(anode.node.left, anode.code * 2));
                nodes.add(new ANode(anode.node.right, anode.code * 2 + 1));
            }
        }

        return nodes.get(i - 1).code == nodes.size();
    }
}

class ANode {
    TreeNode node;
    int code;

    ANode(TreeNode node, int code) {
        this.node = node;
        this.code = code;
    }
}