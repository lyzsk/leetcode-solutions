import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author sichu
 * @date 2022/12/30
 **/
public class ExamRoom {
    private int n;
    private TreeSet<Integer> seats;
    private PriorityQueue<int[]> pq;

    public ExamRoom(int n) {
        this.n = n;
        this.seats = new TreeSet<>();
        this.pq = new PriorityQueue<>((o1, o2) -> {
            int diff1 = o1[1] - o1[0];
            int diff2 = o2[1] - o2[0];
            return diff1 / 2 < diff2 / 2 || (diff1 / 2 == diff2 / 2 && o1[0] > o2[0]) ? 1 : -1;
        });
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }
        int left = seats.first();
        int right = n - 1 - seats.last();
        while (seats.size() >= 2) {
            int[] p = pq.peek();
            if (seats.contains(p[0]) && seats.contains(p[1]) && seats.higher(p[0]) == p[1]) {
                int diff = p[1] - p[0];
                if (diff / 2 < right || diff / 2 <= left) {
                    break;
                }
                pq.poll();
                pq.offer(new int[] {p[0], p[0] + diff / 2});
                pq.offer(new int[] {p[0] + diff / 2, p[1]});
                seats.add(p[0] + diff / 2);
                return p[0] + diff / 2;
            }
            pq.poll();
        }
        if (right > left) {
            pq.offer(new int[] {seats.last(), n - 1});
            seats.add(n - 1);
            return n - 1;
        } else {
            pq.offer(new int[] {0, seats.first()});
            seats.add(0);
            return 0;
        }
    }

    public void leave(int p) {
        if (p != seats.first() && p != seats.last()) {
            int prev = seats.lower(p);
            int next = seats.higher(p);
            pq.offer(new int[] {prev, next});
        }
        seats.remove(p);
    }
}
