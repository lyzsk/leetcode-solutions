import java.util.PriorityQueue;

/**
 * @author sichu
 * @date 2023/11/06
 **/
public class SeatManager {
    private int last;
    private PriorityQueue<Integer> minheap;

    public SeatManager(int n) {
        this.last = 0;
        this.minheap = new PriorityQueue<>();
    }

    public int reserve() {
        if (minheap.isEmpty()) {
            return ++last;
        } else {
            return minheap.poll();
        }
    }

    public void unreserve(int seatNumber) {
        if (seatNumber == last) {
            --last;
        } else {
            minheap.offer(seatNumber);
        }
    }
}
