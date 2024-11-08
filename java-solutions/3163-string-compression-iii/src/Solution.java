import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu huang
 * @since 2024/11/04 15:30
 */
public class Solution {
    public String compressedString(String word) {
        Deque<Character> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : word.toCharArray()) {
            if (deque1.isEmpty() || deque1.peekLast() != ch) {
                deque1.add(ch);
                deque2.add(0);
            }
            if (!deque2.isEmpty() && deque2.peekLast() == 9) {
                deque1.add(deque1.peekLast());
                deque2.add(0);
            }
            Integer i = deque2.removeLast();
            deque2.addLast(i + 1);
        }
        while (!deque1.isEmpty()) {
            sb.append(deque2.pollFirst());
            sb.append(deque1.pollFirst());
        }
        return sb.toString();
    }
}