/**
 * @author sichu huang
 * @since 2025/01/17 21:58
 */
public class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xorValue = 0;
        for (int num : derived) {
            xorValue ^= num;
        }
        return xorValue == 0;
    }
}
