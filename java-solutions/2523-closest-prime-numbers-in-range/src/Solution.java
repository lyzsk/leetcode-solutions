import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sichu huang
 * @since 2025/03/07 15:51
 */
public class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] sieve = new boolean[right + 1];
        Arrays.fill(sieve, true);
        sieve[0] = sieve[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= right; j += i) {
                    sieve[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }
        if (primes.size() < 2) {
            return new int[] {-1, -1};
        }
        int minGap = Integer.MAX_VALUE;
        int[] res = {-1, -1};
        for (int i = 1; i < primes.size(); i++) {
            int gap = primes.get(i) - primes.get(i - 1);
            if (gap < minGap) {
                minGap = gap;
                res[0] = primes.get(i - 1);
                res[1] = primes.get(i);
            }
        }
        return res;
    }
}
