import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sichu huang
 * @since 2026/05/13 18:50
 */
public class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        Map<Integer, Integer> sumCount = new HashMap<>();
        int[] minArr = new int[n / 2];
        int[] maxArr = new int[n / 2];
        for (int i = 0; i < n / 2; i++) {
            int a = Math.min(nums[i], nums[n - 1 - i]);
            int b = Math.max(nums[i], nums[n - 1 - i]);
            sumCount.merge(a + b, 1, Integer::sum);
            minArr[i] = a;
            maxArr[i] = b;
        }
        Arrays.sort(minArr);
        Arrays.sort(maxArr);
        int minOps = n;
        for (int c = 2; c <= 2 * limit; c++) {
            int addLeft = n / 2 - lowerBound(minArr, c);
            int addRight = lowerBound(maxArr, c - limit);

            int currentOps = n / 2 + addLeft + addRight - sumCount.getOrDefault(c, 0);
            minOps = Math.min(minOps, currentOps);
        }
        return minOps;
    }

    private int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
