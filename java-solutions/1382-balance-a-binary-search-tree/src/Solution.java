import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu huang
 * @date 2024/06/26
 **/
public class Solution {
    List<Integer> inorderList = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        getInorder(root);
        return build(0, inorderList.size() - 1);
    }

    private void getInorder(TreeNode root) {
        if (root.left != null) {
            getInorder(root.left);
        }
        inorderList.add(root.val);
        if (root.right != null) {
            getInorder(root.right);
        }
    }

    private TreeNode build(int left, int right) {
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(inorderList.get(mid));
        if (left <= mid - 1) {
            root.left = build(left, mid - 1);
        }
        if (mid + 1 <= right) {
            root.right = build(mid + 1, right);
        }
        return root;
    }
}
