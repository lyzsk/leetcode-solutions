import java.util.Arrays;

/**
 *
 * @author sichu huang
 * @since 2026/06/05 17:33
 */
public class Solution {
    private String s;
    private int n;
    private long[][][] memo_cnt;
    private long[][][] memo_sum;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long num) {
        if (num < 100) {
            return 0L;
        }
        s = Long.toString(num);
        n = s.length();

        memo_cnt = new long[16][10][10];
        memo_sum = new long[16][10][10];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(memo_cnt[i][j], -1);
                Arrays.fill(memo_sum[i][j], -1);
            }
        }

        long[] result = dfs(0, -1, -1, true, true);
        return result[1];
    }

    private long[] dfs(int pos, int prev, int curr, boolean isLimit, boolean isLeading) {
        if (pos == n) {
            return new long[] {1L, 0L};
        }
        if (!isLimit && !isLeading && prev >= 0 && curr >= 0) {
            if (memo_cnt[pos][prev][curr] != -1) {
                return new long[] {memo_cnt[pos][prev][curr], memo_sum[pos][prev][curr]};
            }
        }

        long cnt = 0, sum = 0;
        int up = isLimit ? (s.charAt(pos) - '0') : 9;
        for (int digit = 0; digit <= up; ++digit) {
            boolean newLeading = isLeading && (digit == 0);
            int newPrev = curr;
            int newCurr = newLeading ? -1 : digit;
            long[] sub = dfs(pos + 1, newPrev, newCurr, isLimit && (digit == up), newLeading);
            long subCnt = sub[0], subSum = sub[1];
            if (!newLeading && prev >= 0 && curr >= 0) {

                if ((prev < curr && curr > digit) || (prev > curr && curr < digit)) {
                    sum += subCnt;
                }
            }

            cnt += subCnt;
            sum += subSum;
        }

        if (!isLimit && !isLeading && prev >= 0 && curr >= 0) {
            memo_cnt[pos][prev][curr] = cnt;
            memo_sum[pos][prev][curr] = sum;
        }

        return new long[] {cnt, sum};
    }
}
