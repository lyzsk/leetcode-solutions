import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @date 2024/09/15
 **/
public class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int mask = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                mask ^= 1;
            } else if (ch == 'e') {
                mask ^= (1 << 1);
            } else if (ch == 'i') {
                mask ^= (1 << 2);
            } else if (ch == 'o') {
                mask ^= (1 << 3);
            } else if (ch == 'u') {
                mask ^= (1 << 4);
            }
            if (map.containsKey(mask)) {
                res = Math.max(res, i - map.get(mask));
            } else {
                map.put(mask, i);
            }
        }
        return res;
    }
}
