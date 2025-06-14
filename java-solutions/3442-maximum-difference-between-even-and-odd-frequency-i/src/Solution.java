import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2025/06/10 19:50
 */
public class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> c = new HashMap<>();
        for (char ch : s.toCharArray()) {
            c.put(ch, c.getOrDefault(ch, 0) + 1);
        }
        int maxOdd = 1, minEven = s.length();
        for (int value : c.values()) {
            if (value % 2 == 1) {
                maxOdd = Math.max(maxOdd, value);
            } else {
                minEven = Math.min(minEven, value);
            }
        }
        return maxOdd - minEven;
    }
}
