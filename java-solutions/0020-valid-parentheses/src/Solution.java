import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu
 * @date 2022/09/30
 **/
public class Solution {
    private static boolean match(char left, char right) {
        return (left == '(' && right == ')') || (left == '{' && right == '}') || (left == '[' && right == ']');
    }

    public boolean isValid(String s) {
        if (s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                deque.addLast(ch);
            } else if (deque.isEmpty() || !match(deque.removeLast(), ch)) {
                return false;
            }
        }
        return deque.isEmpty();
    }
}
