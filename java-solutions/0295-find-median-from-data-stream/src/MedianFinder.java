import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author sichu
 * @date 2022/11/12
 **/
public class MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder() {
        this.left = new PriorityQueue<>(Collections.reverseOrder());
        this.right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        int s1 = left.size();
        int s2 = right.size();
        if (s1 == s2) {
            if (right.isEmpty() || num < right.peek()) {
                left.add(num);
            } else {
                left.add(right.poll());
                right.add(num);
            }
        } else {
            if (left.peek() <= num) {
                right.add(num);
            } else {
                right.add(left.poll());
                left.add(num);
            }
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }
        return (double)left.peek();
    }
}
