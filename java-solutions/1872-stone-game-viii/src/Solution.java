/**
 *
 * @author sichu huang
 * @since 2026/08/24
 */
public class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int max = sum;
        for (int i = n - 1; i >= 2; --i) {
            sum -= stones[i];
            max = Math.max(max, sum - max);
        }
        return max;
    }
}
