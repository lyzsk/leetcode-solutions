import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/12/07
 **/
public class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> ch2str = new HashMap<>(16);
        Map<String, Character> str2ch = new HashMap<>(16);
        int i = 0;
        for (int p = 0; p < pattern.length(); p++) {
            if (i >= s.length()) {
                return false;
            }
            int j = i;
            while (j < s.length() && s.charAt(j) != ' ') {
                ++j;
            }
            char ch = pattern.charAt(p);
            String str = s.substring(i, j);
            if (ch2str.containsKey(ch) && !str.equals(ch2str.get(ch))) {
                return false;
            }
            if (str2ch.containsKey(str) && str2ch.get(str) != ch) {
                return false;
            }
            ch2str.put(ch, str);
            str2ch.put(str, ch);
            i = j + 1;
        }
        return i >= s.length();
    }
}
