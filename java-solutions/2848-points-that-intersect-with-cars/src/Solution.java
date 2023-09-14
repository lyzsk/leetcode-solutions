import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author sichu
 * @date 2023/09/10
 **/
public class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        nums.sort(Comparator.comparingInt(o -> o.get(0)));
        int n = nums.size();
        List<int[]> merged = new ArrayList<>();
        for (List<Integer> num : nums) {
            int left = num.get(0);
            int right = num.get(1);
            if (merged.isEmpty() || left > merged.get(merged.size() - 1)[1]) {
                merged.add(new int[] {left, right});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
            }
        }
        int res = 0;
        for (int[] merge : merged) {
            res += (merge[1] - merge[0] + 1);
        }
        return res;
    }
}
