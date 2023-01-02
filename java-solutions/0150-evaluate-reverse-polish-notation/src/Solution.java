import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu
 * @date 2022/12/17
 **/
public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                stack.addFirst(Integer.parseInt(token));
            } else {
                int num2 = stack.removeFirst();
                int num1 = stack.removeFirst();
                switch (token) {
                    case "+":
                        stack.addFirst(num1 + num2);
                        break;
                    case "-":
                        stack.addFirst(num1 - num2);
                        break;
                    case "*":
                        stack.addFirst(num1 * num2);
                        break;
                    case "/":
                        stack.addFirst(num1 / num2);
                        break;
                    default:
                }
            }
        }
        return stack.removeFirst();
    }

    private boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
