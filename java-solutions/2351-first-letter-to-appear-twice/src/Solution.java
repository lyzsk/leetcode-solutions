import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu
 * @since 2022/12/31
 **/
public class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (!set.add(ch)) {
                return ch;
            }
        }
        return ' ';
    }
}
