import java.util.Arrays;

/**
 * @author sichu huang
 * @since 2025/12/31 15:15
 */
public class Solution {
    public int numOfStrings(String[] patterns, String word) {
        return (int)Arrays.stream(patterns).filter(s -> word.indexOf(s) >= 0).count();
    }
}
