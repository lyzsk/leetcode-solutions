package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 *
 * @author sichu
 * @date 2022/08/21
 **/
public class Solution {
    private static int calculateHeight(TreeNode root) {
        int res = 0;
        if (root.left != null) {
            res = Math.max(res, calculateHeight(root.left) + 1);
        }
        if (root.right != null) {
            res = Math.max(res, calculateHeight(root.right) + 1);
        }
        return res;
    }

    private static void dfs(List<List<String>> res, TreeNode root, int row, int col, int height) {
        res.get(row).set(col, Integer.toString(root.val));
        if (root.left != null) {
            dfs(res, root.left, row + 1, col - (1 << (height - row - 1)), height);
        }
        if (root.right != null) {
            dfs(res, root.right, row + 1, col + (1 << (height - row - 1)), height);
        }
    }

    /**
     * height从0开始
     *
     * @param root given
     * @return res
     */
    public List<List<String>> printTree(TreeNode root) {
        int height = calculateHeight(root);
        int m = height + 1;
        int n = (1 << (height + 1)) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add("");
            }
            res.add(row);
        }
        dfs(res, root, 0, (n - 1) / 2, height);
        return res;
    }
}
