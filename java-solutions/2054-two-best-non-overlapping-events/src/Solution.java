import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author sichu huang
 * @since 2024/12/08 14:21
 */
public class Solution {
    public int maxTwoEvents(int[][] events) {
        List<Event> evs = new ArrayList<>();
        for (int[] event : events) {
            evs.add(new Event(event[0], 0, event[2]));
            evs.add(new Event(event[1], 1, event[2]));
        }
        Collections.sort(evs, (o1, o2) -> {
            if (o1.ts > o2.ts) {
                return 1;
            } else if (o1.ts < o2.ts) {
                return -1;
            }
            return o1.op - o2.op;
        });
        int res = 0, bestFirst = 0;
        for (Event ev : evs) {
            if (ev.op == 0) {
                res = Math.max(res, ev.val + bestFirst);
            } else {
                bestFirst = Math.max(bestFirst, ev.val);
            }
        }
        return res;
    }

    private static class Event {
        int ts;
        int op;
        int val;

        Event(int ts, int op, int val) {
            this.ts = ts;
            this.op = op;
            this.val = val;
        }
    }
}
