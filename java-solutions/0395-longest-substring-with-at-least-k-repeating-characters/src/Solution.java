import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/11/14
 **/
public class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }
        Map<Character, Integer> freq = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char ch : freq.keySet()) {
            if (freq.get(ch) < k) {
                int res = 0;
                for (String str : s.split(String.valueOf(ch))) {
                    res = Math.max(res, longestSubstring(str, k));
                }
                return res;
            }
        }
        return s.length();
    }
}
