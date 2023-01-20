import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sichu
 * @date 2023/01/20
 **/
public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 2) {
            return res;
        }
        List<Integer> path = new ArrayList<>();
        backtrack(res, path, nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, int index) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (path.size() != 0 && path.get(path.size() - 1) > nums[i]) {
                continue;
            }
            if (visited.contains(nums[i])) {
                continue;
            }
            visited.add(nums[i]);
            path.add(nums[i]);
            backtrack(res, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
