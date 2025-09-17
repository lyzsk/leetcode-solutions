import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu huang
 * @since 2025/09/16 02:00
 */
public class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> broken = new HashSet<>();
        for (char ch : brokenLetters.toCharArray()) {
            broken.add(ch);
        }
        int res = 0;
        boolean flag = true;
        for (char ch : text.toCharArray()) {
            if (ch == ' ') {
                if (flag) {
                    ++res;
                }
                flag = true;
            } else if (broken.contains(ch)) {
                flag = false;
            }
        }
        if (flag) {
            ++res;
        }
        return res;
    }
}
