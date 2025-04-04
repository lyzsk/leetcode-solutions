import java.util.*;

/**
 * @author sichu huang
 * @since 2025/03/29 19:33
 */
public class Solution {
    private final int mod = (int)1e9 + 7;

    public int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int[][] arr = new int[n][0];
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[] {i, primeFactors(nums.get(i)), nums.get(i)};
        }
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int[] e : arr) {
            int i = e[0], f = e[1];
            while (!deque.isEmpty() && arr[deque.peek()][1] < f) {
                deque.pop();
            }
            if (!deque.isEmpty()) {
                left[i] = deque.peek();
            }
            deque.push(i);
        }
        deque.clear();
        for (int i = n - 1; i >= 0; --i) {
            int f = arr[i][1];
            while (!deque.isEmpty() && arr[deque.peek()][1] <= f) {
                deque.pop();
            }
            if (!deque.isEmpty()) {
                right[i] = deque.peek();
            }
            deque.push(i);
        }
        Arrays.sort(arr, (a, b) -> b[2] - a[2]);
        long res = 1;
        for (int[] e : arr) {
            int i = e[0], x = e[2];
            int l = left[i], r = right[i];
            long cnt = (long)(i - l) * (r - i);
            if (cnt <= k) {
                res = res * qpow(x, cnt) % mod;
                k -= cnt;
            } else {
                res = res * qpow(x, k) % mod;
                break;
            }
        }
        return (int)res;
    }

    private int primeFactors(int n) {
        int i = 2;
        Set<Integer> res = new HashSet<>();
        while (i <= n / i) {
            while (n % i == 0) {
                res.add(i);
                n /= i;
            }
            ++i;
        }
        if (n > 1) {
            res.add(n);
        }
        return res.size();
    }

    private int qpow(long a, long n) {
        long res = 1L;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                res = res * a % mod;
            }
            a = a * a % mod;
        }
        return (int)res;
    }
}
