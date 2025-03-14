/**
 * @author sichu huang
 * @since 2025/03/14 16:41
 */
public class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        long left = 0;
        long right = sum / k + 1;
        while (left + 1 != right) {
            long mid = (left + right) >> 1;
            if (canDesign(candies, k, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (int)left;
    }

    private boolean canDesign(int[] candies, long k, long num) {
        if (num == 0) {
            return true;
        }
        long cnt = 0;
        for (int candy : candies) {
            cnt += candy / num;
        }
        return cnt >= k;
    }
}
