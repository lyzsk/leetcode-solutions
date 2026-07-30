/**
 *
 * @author sichu huang
 * @since 2026/07/30
 */
public class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int blocks = n / 8;
        return (blocks * (blocks + 1) * 4) + (n % 8) * (blocks + 1);
    }
}
