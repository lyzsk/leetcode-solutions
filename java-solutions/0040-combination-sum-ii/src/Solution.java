import java.util.*;

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
            backtrack(res, path, candidates, target - candidates[i], i + 1);
            path.removeLast();
            while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                ++i;
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        backtrack(res, path, candidates, target, 0);
        return res;
    }
}
