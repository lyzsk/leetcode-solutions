import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/12/01
 **/
public class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            postorderTraversal(child, res);
        }
        res.add(root.val);
    }
}
