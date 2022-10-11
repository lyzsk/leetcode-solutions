import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu
 * @date 2022/10/11
 **/
public class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char digit : num.toCharArray()) {
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.removeLast();
                --k;
            }
            deque.addLast(digit);
        }
        for (int i = 0; i < k; i++) {
            deque.removeLast();
        }
        StringBuilder res = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.removeFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            res.append(digit);
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
