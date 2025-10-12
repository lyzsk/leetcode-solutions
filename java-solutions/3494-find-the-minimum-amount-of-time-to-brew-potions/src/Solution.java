/**
 * @author sichu huang
 * @since 2025/10/09 23:44
 */
public class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long[] times = new long[n];
        for (int k : mana) {
            long curTime = 0;
            for (int i = 0; i < n; i++) {
                curTime = Math.max(curTime, times[i]) + (long)skill[i] * k;
            }
            times[n - 1] = curTime;
            for (int i = n - 2; i >= 0; i--) {
                times[i] = times[i + 1] - (long)skill[i + 1] * k;
            }
        }
        return times[n - 1];
    }
}
