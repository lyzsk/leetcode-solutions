/**
 *
 * @author sichu huang
 * @since 2026/06/24
 */
public class Solution {
    private static final int MOD = (int)1e9 + 7;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m];
        for (int i = 0; i < m; i++)
            up[i] = i;

        long[][] T = new long[m][m];
        for (int i = 1; i < m; i++)
            for (int k = m - i; k < m; k++)
                T[i][k] = 1;

        long[][] Tn = matpow(T, n - 2, m);

        long ans = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < m; j++)
                ans = (ans + Tn[i][j] * up[j]) % MOD;

        return (int)(ans * 2 % MOD);
    }

    private long[][] matmul(long[][] A, long[][] B, int sz) {
        long[][] C = new long[sz][sz];
        for (int i = 0; i < sz; i++)
            for (int k = 0; k < sz; k++) {
                if (A[i][k] == 0)
                    continue;
                for (int j = 0; j < sz; j++)
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
            }
        return C;
    }

    private long[][] matpow(long[][] M, int p, int sz) {
        long[][] res = new long[sz][sz];
        for (int i = 0; i < sz; i++)
            res[i][i] = 1;
        while (p > 0) {
            if ((p & 1) == 1)
                res = matmul(res, M, sz);
            M = matmul(M, M, sz);
            p >>= 1;
        }
        return res;
    }
}
