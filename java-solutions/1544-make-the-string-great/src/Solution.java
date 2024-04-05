import java.util.Stack;

/**
 * @author sichu huang
 * @date 2024/04/05
 **/
public class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(ch - stack.peek()) == 32) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}
