package dfs;

import java.util.HashMap;
import java.util.Map;

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
 * @date 2022/08/26
 **/
public class Solution {
    private Map<Integer, Integer> map = new HashMap<>(16);

    private int dfs(TreeNode root, int depth, int index) {
        if (root == null) {
            return 0;
        }
        map.putIfAbsent(depth, index);
        return Math.max(index - map.get(depth) + 1,
            Math.max(dfs(root.left, depth + 1, index * 2), dfs(root.right, depth + 1, index * 2 + 1)));
    }

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }
}
