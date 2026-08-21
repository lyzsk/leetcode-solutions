import java.util.Arrays;

/**
 *
 * @author sichu huang
 * @since 2026/08/21
 */
public class Solution {
    public long findKthSmallest(int[] coins, int k) {
        Arrays.sort(coins);
        int n = coins.length;
        int m = 1 << n;

        long l = k;
        long r = (long)coins[0] * k + 1;

        int[] bitCount = new int[m];
        long[] lcm = new long[m];

        for (int mask = 1; mask < m; mask++) {
            long curLcm = 1;
            for (int i = 0; i < n; i++) {
                if ((mask >> i & 1) == 1) {
                    long g = gcd(curLcm, coins[i]);
                    long tmp = curLcm / g;

                    if (tmp <= r / coins[i]) {
                        curLcm = tmp * coins[i];
                    } else {
                        curLcm = r + 1;
                        break;
                    }
                    bitCount[mask]++;
                }
            }
            lcm[mask] = curLcm;
        }

        while (l < r) {
            long x = l + (r - l) / 2;
            if (count(x, m, lcm, bitCount) >= k) {
                r = x;
            } else {
                l = x + 1;
            }
        }
        return l;
    }

    private long count(long x, int m, long[] lcm, int[] bitCount) {
        long res = 0;
        for (int mask = 1; mask < m; mask++) {
            if (lcm[mask] > x)
                continue;

            if ((bitCount[mask] & 1) == 1) {
                res += x / lcm[mask];
            } else {
                res -= x / lcm[mask];
            }
        }
        return res;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
