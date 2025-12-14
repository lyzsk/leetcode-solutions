/**
 * @author sichu huang
 * @since 2025/12/10 16:44
 */
public class Solution {
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }
        int res = 1;
        int mod = (int)(1e9 + 7);
        for (int i = 2; i < n; i++) {
            res = (int)((long)res * i % mod);
        }
        return res;
    }
}
