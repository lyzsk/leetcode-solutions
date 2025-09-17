/**
 * @author sichu huang
 * @since 2025/09/13 01:17
 */
public class Solution {
    public boolean doesAliceWin(String s) {
        return s.chars().anyMatch(c -> "aeiou".indexOf(c) != -1);
    }

}
