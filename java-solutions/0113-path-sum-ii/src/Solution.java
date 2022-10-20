import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author sichu
 * @date 2022/10/21
 **/
public class Solution {
    private static void backtrack(List<List<Integer>> res, Deque<Integer> path, TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.addLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<>(path));
        }
        backtrack(res, path, root.left, targetSum);
        backtrack(res, path, root.right, targetSum);
        path.removeLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(res, path, root, targetSum);
        return res;
    }
}
