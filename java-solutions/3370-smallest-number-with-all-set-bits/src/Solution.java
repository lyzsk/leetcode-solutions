/**
 * @author sichu huang
 * @since 2025/10/29 20:04
 */
public class Solution {
    public int smallestNumber(int n) {
        int x = 1;
        while (x < n) {
            x = x * 2 + 1;
        }
        return x;
    }
}
