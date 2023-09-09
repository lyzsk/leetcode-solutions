/**
 * @author sichu
 * @date 2023/09/07
 **/
public class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = (long)ranks[0] * cars * cars;
        while (left < right) {
            long mid = left + ((right - left) >> 1);
            if (check(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] ranks, int cars, long mid) {
        long cnt = 0L;
        for (int r : ranks) {
            cnt += (long)Math.sqrt(mid / r);
        }
        return cnt >= cars;
    }
}
