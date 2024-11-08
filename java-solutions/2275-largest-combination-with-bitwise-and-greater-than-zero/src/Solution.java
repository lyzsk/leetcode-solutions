/**
 * @author sichu huang
 * @since 2024/11/07 14:22
 */
public class Solution {
    public int largestCombination(int[] candidates) {
        int[] cnt = new int[32];
        int max = 0;
        for (int c : candidates) {
            for (int i = 0; i < 32; i++) {
                if (((1 << i) & c) > 0) {
                    cnt[i]++;
                }
            }
        }
        for (int i = 0; i < 32; i++) {
            max = Math.max(max, cnt[i]);
        }
        return max;
    }
}
