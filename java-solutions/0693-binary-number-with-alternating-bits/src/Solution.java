/**
 * @author sichu huang
 * @since 2026/02/18 13:02
 */
public class Solution {
    public boolean hasAlternatingBits(int n) {
        int a = n ^ (n >> 1);
        return (a & (a + 1)) == 0;
    }
}
