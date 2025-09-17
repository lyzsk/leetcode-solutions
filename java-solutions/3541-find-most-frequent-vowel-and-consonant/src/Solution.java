import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @since 2025/09/14 00:35
 */
public class Solution {
    public int maxFreqSum(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int vowel = 0, consonant = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (isVowel(ch)) {
                vowel = Math.max(vowel, map.getOrDefault(ch, 0));
            } else {
                consonant = Math.max(consonant, map.getOrDefault(ch, 0));
            }
        }
        return vowel + consonant;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
