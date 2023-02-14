import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/10/02
 **/
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(res, root);
        return res;
    }

    private void inorderTraversal(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(res, root.left);
        res.add(root.val);
        inorderTraversal(res, root.right);
    }
}
