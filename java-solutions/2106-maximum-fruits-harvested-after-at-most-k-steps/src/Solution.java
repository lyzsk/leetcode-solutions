/**
 * @author sichu huang
 * @since 2025/08/04 00:42
 */
public class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = 0;
        int right = 0;
        int n = fruits.length;
        int sum = 0;
        int res = 0;
        while (right < n) {
            sum += fruits[right][1];
            while (left <= right && step(fruits, startPos, left, right) > k) {
                sum -= fruits[left][1];
                left++;
            }
            res = Math.max(res, sum);
            right++;
        }
        return res;
    }

    private int step(int[][] fruits, int startPos, int left, int right) {
        return Math.min(Math.abs(startPos - fruits[right][0]), Math.abs(startPos - fruits[left][0]))
            + fruits[right][0] - fruits[left][0];
    }
}
