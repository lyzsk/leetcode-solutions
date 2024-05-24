import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @date 2024/05/23
 **/
public class Solution {
    private int res = 0;

    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        dfs(nums, 0, k, map);
        return res - 1;
    }

    private void dfs(int[] nums, int idx, int k, Map<Integer, Integer> map) {
        if (idx == nums.length) {
            ++res;
            return;
        }
        dfs(nums, idx + 1, k, map);
        if (!map.containsKey(nums[idx] - k) && !map.containsKey(nums[idx] + k)) {
            map.put(nums[idx], map.getOrDefault(nums[idx], 0) + 1);
            dfs(nums, idx + 1, k, map);
            map.put(nums[idx], map.getOrDefault(nums[idx], 0) - 1);
            if (map.get(nums[idx]) == 0) {
                map.remove(nums[idx]);
            }
        }
    }
}
