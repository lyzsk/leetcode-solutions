import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2025/03/10 17:54
 */
public class Solution {
    public long countOfSubstrings(String word, int k) {
        return atLeastK(word, k) - atLeastK(word, k + 1);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private long atLeastK(String word, int k) {
        int n = word.length();
        long res = 0;
        int consonants = 0;
        int left = 0;
        Map<Character, Integer> vowelMap = new HashMap<>();
        for (int right = 0; right < n; right++) {
            char c = word.charAt(right);
            if (isVowel(c)) {
                vowelMap.put(c, vowelMap.getOrDefault(c, 0) + 1);
            } else {
                consonants++;
            }
            while (vowelMap.size() == 5 && consonants >= k) {
                res += n - right;
                char leftChar = word.charAt(left);
                if (isVowel(leftChar)) {
                    vowelMap.put(leftChar, vowelMap.get(leftChar) - 1);
                    if (vowelMap.get(leftChar) == 0) {
                        vowelMap.remove(leftChar);
                    }
                } else {
                    consonants--;
                }
                left++;
            }
        }
        return res;
    }
}
