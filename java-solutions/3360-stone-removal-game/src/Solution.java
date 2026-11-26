/**
 *
 * @author sichu huang
 * @since 2026/11/26
 */
public class Solution {
    public boolean canAliceWin(int n) {
        int k = (int)((21 - Math.sqrt(441 - 8 * n)) / 2);
        return k % 2 == 1;
    }
}
