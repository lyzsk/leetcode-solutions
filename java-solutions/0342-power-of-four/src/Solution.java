/**
 * @author sichu huang
 * @since 2025/08/16 01:22
 */
public class Solution {
    public boolean isPowerOfFour(int n) {
        return (n & (n - 1)) == 0 && n % 3 == 1;
    }

}
