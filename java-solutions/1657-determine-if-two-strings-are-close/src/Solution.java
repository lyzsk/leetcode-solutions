import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/12/02
 **/
public class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            ++freq1[word1.charAt(i) - 'a'];
            ++freq2[word2.charAt(i) - 'a'];
        }
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }
        Map<Integer, Integer> map = new HashMap<>(26);
        for (int i = 0; i < 26; i++) {
            map.put(freq1[i], map.getOrDefault(freq1[i], 0) + 1);
            map.put(freq2[i], map.getOrDefault(freq2[i], 0) - 1);
        }
        for (Integer freq : map.keySet()) {
            if (map.get(freq) != 0) {
                return false;
            }
        }
        return true;
    }
}
