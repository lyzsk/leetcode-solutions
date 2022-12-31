import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sichu
 * @date 2022/12/31
 **/
public class CQueue {
    private Deque<Integer> inStack;
    private Deque<Integer> outStack;

    public CQueue() {
        this.inStack = new ArrayDeque<>();
        this.outStack = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        this.inStack.addFirst(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty()) {
            if (inStack.isEmpty()) {
                return -1;
            }
            in2Out();
        }
        return outStack.removeFirst();
    }

    private void in2Out() {
        while (!inStack.isEmpty()) {
            outStack.addFirst(inStack.removeFirst());
        }
    }
}
