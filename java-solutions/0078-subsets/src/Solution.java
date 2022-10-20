import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author sichu
 * @date 2022/10/20
 **/
public class Solution {
    private static void backtrack(List<List<Integer>> res, Deque<Integer> path, int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.addLast(nums[i]);
            backtrack(res, path, nums, i + 1);
            path.removeLast();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        backtrack(res, path, nums, 0);
        return res;
    }
}
