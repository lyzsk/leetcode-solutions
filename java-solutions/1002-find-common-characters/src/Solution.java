import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sichu huang
 * @date 2024/06/05
 **/
public class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (String word : words) {
            int[] freq = new int[26];
            for (char ch : word.toCharArray()) {
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; i++) {
                count[i] = Math.min(count[i], freq[i]);
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i]; j++) {
                result.add(String.valueOf((char)('a' + i)));
            }
        }
        return result;
    }
}
