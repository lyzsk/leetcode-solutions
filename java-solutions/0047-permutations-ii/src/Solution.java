import java.util.*;

/**
 * @author sichu
 * @date 2022/09/30
 **/
public class Solution {
    private static void backtrack(int[] nums, boolean[] used, Deque<Integer> path, List<List<Integer>> res, int depth) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            backtrack(nums, used, path, res, depth + 1);
            path.removeLast();
            used[i] = false;
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, used, path, res, 0);
        return res;
    }
}
