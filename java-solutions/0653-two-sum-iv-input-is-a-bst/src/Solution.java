import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/10/09
 **/
public class Solution {
    private final List<Integer> list = new ArrayList<>();

    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }

    public boolean findTarget(TreeNode root, int k) {
        inorderTraversal(root);
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) + list.get(right) == k) {
                return true;
            } else if (list.get(left) + list.get(right) < k) {
                ++left;
            } else {
                --right;
            }
        }
        return false;
    }
}
