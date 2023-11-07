/**
 * @author sichu
 * @date 2023/11/07
 **/
public class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arrivalTimes = new int[n];
        for (int i = 0; i < n; i++) {
            arrivalTimes[i] = (int)Math.ceil((double)dist[i] / speed[i]);
            speed[i] = 0;
        }
        for (int arrivalTime : arrivalTimes) {
            if (arrivalTime >= n) {
                continue;
            }
            ++speed[arrivalTime];
        }
        for (int i = 1; i < n; i++) {
            speed[i] += speed[i - 1];
            if (speed[i] > i) {
                return i;
            }
        }
        return n;
    }
}
