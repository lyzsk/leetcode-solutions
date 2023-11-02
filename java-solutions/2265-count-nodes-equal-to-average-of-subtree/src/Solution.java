/**
 * @author sichu
 * @date 2023/11/02
 **/
public class Solution {
    private int res = 0;

    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return -1;
        }
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int sum = left[0] + right[0] + root.val;
        int cnt = left[1] + right[1] + 1;
        if (cnt != 0 && sum / cnt == root.val) {
            ++res;
        }
        return new int[] {sum, cnt};
    }
}
