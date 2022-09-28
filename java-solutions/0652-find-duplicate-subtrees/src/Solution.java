import javafx.util.Pair;

import java.util.*;

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
 * @date 2022/09/05
 **/
public class Solution {
    private final Map<String, Pair<TreeNode, Integer>> cache = new HashMap<>(16);
    private final Set<TreeNode> duplicate = new HashSet<>();
    private int idx = 0;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(duplicate);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int[] tri = {root.val, dfs(root.left), dfs(root.right)};
        String hash = Arrays.toString(tri);
        if (cache.containsKey(hash)) {
            Pair<TreeNode, Integer> pair = cache.get(hash);
            duplicate.add(pair.getKey());
            return pair.getValue();
        } else {
            ++idx;
            cache.put(hash, new Pair<>(root, idx));
            return idx;
        }
    }
}
