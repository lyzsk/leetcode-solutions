/**
 * @author sichu
 * @date 2023/08/20
 **/
public class Solution {
    public boolean checkTree(TreeNode root) {
        return root.left.val + root.right.val == root.val;
    }
}
