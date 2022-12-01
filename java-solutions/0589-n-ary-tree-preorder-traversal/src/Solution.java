import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/12/01
 **/
public class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node child : root.children) {
            preorderTraversal(child, res);
        }
    }
}
