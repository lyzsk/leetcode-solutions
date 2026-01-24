import java.util.List;

/**
 * @author sichu huang
 * @since 2026/01/20 18:18
 */
public class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int res[] = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);
            if (n != 2) {
                res[i] = n - ((n + 1) & (-n - 1)) / 2;
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}
