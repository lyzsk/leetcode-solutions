import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2023/01/04
 **/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        Map<Character, Integer> map = new HashMap<>(128);
        for (int left = 0, right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right);
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
