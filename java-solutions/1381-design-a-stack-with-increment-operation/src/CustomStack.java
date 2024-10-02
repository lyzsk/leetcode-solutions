/**
 * @author sichu huang
 * @date 2024/09/30
 **/
public class CustomStack {
    int[] stack;
    int top;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        top = -1;
    }

    public void push(int x) {
        if (top != stack.length - 1) {
            ++top;
            stack[top] = x;
        }
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        --top;
        return stack[top + 1];
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, top + 1);
        for (int i = 0; i < limit; ++i) {
            stack[i] += val;
        }
    }
}
