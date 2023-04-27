import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2023/04/27
 **/
public class Solution {
    public int longestStrChain(String[] words) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>(16);
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String word : words) {
            map.put(word, 1);
            for (int i = 0; i < word.length(); i++) {
                String subseq = word.substring(0, i) + word.substring(i + 1);
                if (map.containsKey(subseq)) {
                    map.put(word, Math.max(map.get(word), map.get(subseq) + 1));
                }
            }
            res = Math.max(res, map.get(word));
        }
        return res;
    }
}
