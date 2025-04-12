import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2025/04/12 14:21
 */
public class Solution {
    public long countGoodIntegers(int n, int k) {
        Set<String> dict = new HashSet<>();
        int base = (int)Math.pow(10, (n - 1) >> 1);
        int skip = n & 1;
        for (int i = base; i < base * 10; i++) {
            String s = Integer.toString(i);
            s += new StringBuilder(s).reverse().substring(skip);
            long palindromicInteger = Long.parseLong(s);
            if (palindromicInteger % k == 0) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                dict.add(new String(chars));
            }
        }
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        long res = 0;
        for (String s : dict) {
            int[] cnt = new int[10];
            for (char c : s.toCharArray()) {
                cnt[c - '0']++;
            }
            long tot = (n - cnt[0]) * factorial[n - 1];
            for (int x : cnt) {
                tot /= factorial[x];
            }
            res += tot;
        }
        return res;
    }
}
