import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu
 * @date 2022/11/22
 **/
public class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> leftStack = new ArrayDeque<>();
        Deque<Integer> asteriskStack = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftStack.addFirst(i);
            } else if (ch == '*') {
                asteriskStack.addFirst(i);
            } else {
                if (!leftStack.isEmpty()) {
                    leftStack.removeFirst();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.removeFirst();
                } else {
                    return false;
                }
            }
        }
        while (!leftStack.isEmpty() && !asteriskStack.isEmpty()) {
            int leftIndex = leftStack.removeFirst();
            int asteriskIndex = asteriskStack.removeFirst();
            if (leftIndex > asteriskIndex) {
                return false;
            }
        }
        return leftStack.isEmpty();
    }
}
