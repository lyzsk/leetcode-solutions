import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu
 * @date 2022/08/17
 **/
public class Solution {
    private static final String[] MORSE =
        {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder code = new StringBuilder();
            for (char ch : word.toCharArray()) {
                code.append(MORSE[ch - 'a']);
            }
            set.add(code.toString());
        }
        return set.size();
    }
}
