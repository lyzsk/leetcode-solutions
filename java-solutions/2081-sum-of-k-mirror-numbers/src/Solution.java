/**
 * @author sichu huang
 * @since 2025/06/24 01:34
 */
public class Solution {
    private final int[] digit = new int[100];

    public long kMirror(int k, int n) {
        int left = 1, count = 0;
        long ans = 0;
        while (count < n) {
            int right = left * 10;
            for (int op = 0; op < 2; ++op) {
                for (int i = left; i < right && count < n; ++i) {
                    long combined = i;
                    int x = (op == 0 ? i / 10 : i);
                    while (x > 0) {
                        combined = combined * 10 + x % 10;
                        x /= 10;
                    }
                    if (isPalindrome(combined, k)) {
                        ++count;
                        ans += combined;
                    }
                }
            }
            left = right;
        }
        return ans;
    }

    private boolean isPalindrome(long x, int k) {
        int length = -1;
        while (x > 0) {
            ++length;
            digit[length] = (int)(x % k);
            x /= k;
        }
        for (int i = 0, j = length; i < j; ++i, --j) {
            if (digit[i] != digit[j]) {
                return false;
            }
        }
        return true;
    }
}
