import java.util.PriorityQueue;

/**
 * @author sichu
 * @date 2023/11/06
 **/
public class SeatManager {
    private PriorityQueue<Integer> pq;

    public SeatManager(int n) {
        this.pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            pq.offer(i);
        }
    }

    public int reserve() {
        if (pq.isEmpty()) {
            return -1;
        }
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}
