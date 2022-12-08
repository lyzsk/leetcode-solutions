import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/12/08
 **/
public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        if (root1 != null) {
            dfs(root1, list1);
        }
        if (root2 != null) {
            dfs(root2, list2);
        }
        return list1.equals(list2);
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val);
        } else {
            if (root.left != null) {
                dfs(root.left, list);
            }
            if (root.right != null) {
                dfs(root.right, list);
            }
        }
    }
}
