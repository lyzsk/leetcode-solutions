import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu
 * @date 2023/08/28
 **/
public class MyStack {
    private Deque<Integer> deque;

    public MyStack() {
        this.deque = new ArrayDeque<>();
    }

    public void push(int x) {
        int n = deque.size();
        deque.addLast(x);
        for (int i = 0; i < n; i++) {
            deque.addLast(deque.removeFirst());
        }
    }

    public int pop() {
        return deque.removeFirst();
    }

    public int top() {
        return deque.peekFirst();
    }

    public boolean empty() {
        return deque.isEmpty();
    }
}
