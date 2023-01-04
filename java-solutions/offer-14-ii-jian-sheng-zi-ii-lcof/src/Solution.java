/**
 * 不能在 dp 中取模, 否则会导致 dp 内的值错误,
 * 除非使用 BigInteger, 但是这会导致效率降低
 *
 * @author sichu
 * @date 2023/01/04
 * @see <a href="https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/solution/di-zi-fen-xi-shi-yong-dong-tai-gui-hua-q-jlr7/">BigInteger解法</a>
 **/
public class Solution {
    public int cuttingRope(int n) {
        final int MOD = (int)1e9 + 7;
        if (n < 3) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= MOD;
            n -= 3;
        }
        return (int)(n * res % MOD);
    }
}
