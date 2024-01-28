import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2024/01/28
 **/
public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int[] nums = new int[n];
            for (int j = i; j < m; j++) {
                Map<Integer, Integer> map = new HashMap<>(n);
                map.put(0, 1);
                sum = 0;
                for (int k = 0; k < n; k++) {
                    nums[k] += matrix[j][k];
                    sum += nums[k];
                    if (map.containsKey(sum - target)) {
                        res += map.get(sum - target);
                    }
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return res;
    }
}
