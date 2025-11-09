import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2025/11/04 18:38
 */
public class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        Map<Integer, Integer> counts = new HashMap<>();
        int[] res = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            int value = nums[i];
            counts.put(value, counts.getOrDefault(value, 0) + 1);
        }
        res[0] = calculateCurrentXSum(counts, x);
        for (int i = 0; i < n - k; i++) {
            int outValue = nums[i];
            int inValue = nums[i + k];
            int currentCount = counts.getOrDefault(outValue, 0);
            if (currentCount <= 1) {
                counts.remove(outValue);
            } else {
                counts.put(outValue, currentCount - 1);
            }
            counts.put(inValue, counts.getOrDefault(inValue, 0) + 1);
            res[i + 1] = calculateCurrentXSum(counts, x);
        }
        return res;
    }

    private int calculateCurrentXSum(Map<Integer, Integer> counts, int x) {
        List<Map.Entry<Integer, Integer>> sortedItems = new ArrayList<>(counts.entrySet());
        sortedItems.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue().compareTo(a.getValue());
            } else {
                return b.getKey().compareTo(a.getKey());
            }
        });
        int l = sortedItems.size();
        int limit = Math.min(x, l);
        int totalSum = 0;
        for (int j = 0; j < limit; j++) {
            Map.Entry<Integer, Integer> entry = sortedItems.get(j);
            int value = entry.getKey();
            int count = entry.getValue();
            totalSum += value * count;
        }
        return totalSum;
    }
}
