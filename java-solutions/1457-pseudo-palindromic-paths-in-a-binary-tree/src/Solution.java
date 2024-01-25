/**
 * @author sichu
 * @date 2024/01/24
 **/
public class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] count = new int[10];
        return dfs(root, count);
    }

    private int dfs(TreeNode root, int[] count) {
        if (root == null) {
            return 0;
        }
        ++count[root.val];
        int res = 0;
        if (root.left == null && root.right == null) {
            if (isPseudoPalindrome(count)) {
                res = 1;
            }
        } else {
            res = dfs(root.left, count) + dfs(root.right, count);
        }
        --count[root.val];
        return res;
    }

    private boolean isPseudoPalindrome(int[] count) {
        int maxOdd = 0;
        for (int i : count) {
            if (i % 2 == 1) {
                ++maxOdd;
            }
        }
        return maxOdd <= 1;
    }
}
