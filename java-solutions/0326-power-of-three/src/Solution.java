/**
 * @author sichu huang
 * @since 2025/08/14 01:03
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
