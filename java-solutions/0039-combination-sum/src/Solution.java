import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author sichu
 * @date 2022/10/20
 **/
public class Solution {
    private static void backtrack(List<List<Integer>> res, Deque<Integer> path, int[] candidates, int target,
        int startIndex) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            backtrack(res, path, candidates, target - candidates[i], i);
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(res, path, candidates, target, 0);
        return res;
    }
}
