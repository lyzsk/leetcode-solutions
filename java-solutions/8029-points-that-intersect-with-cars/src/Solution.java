import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sichu
 * @date 2023/09/10
 **/
public class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        Collections.sort(nums, (o1, o2) -> o1.get(0) - o2.get(0));
        int n = nums.size();
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int left = nums.get(i).get(0);
            int right = nums.get(i).get(1);
            if (merged.isEmpty() || left > merged.get(merged.size() - 1)[1]) {
                merged.add(new int[] {left, right});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
            }
        }
        int res = 0;
        for (int i = 0; i < merged.size(); i++) {
            res += (merged.get(i)[1] - merged.get(i)[0] + 1);
        }
        return res;
    }
}
