import java.util.List;

/**
 * @author sichu huang
 * @since 2025/04/01 23:41
 */
public class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (Integer integer : nums) {
            if (count == 0) {
                max = integer;
            }
            if (max == integer) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == max) {
                count++;
            }
        }
        if (count <= (n - count) + 1) {
            return -1;
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            if (nums.get(i) == max) {
                count++;
            } else {
                count--;
            }
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }
}
