import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/10/24
 **/
public class MyCalendarTwo {
    private final Map<Integer, int[]> tree;

    public MyCalendarTwo() {
        this.tree = new HashMap<>(16);
    }

    public boolean book(int start, int end) {
        update(start, end - 1, 1, 0, 1000000000, 1);
        tree.putIfAbsent(1, new int[2]);
        if (tree.get(1)[0] > 2) {
            update(start, end - 1, -1, 0, 1000000000, 1);
            return false;
        }
        return true;
    }

    private void update(int start, int end, int val, int left, int right,
        int idx) {
        if (right < start || end < left) {
            return;
        }
        tree.putIfAbsent(idx, new int[2]);
        if (start <= left && right <= end) {
            tree.get(idx)[0] += val;
            tree.get(idx)[1] += val;
        } else {
            int mid = left + ((right - left) >> 1);
            update(start, end, val, left, mid, 2 * idx);
            update(start, end, val, mid + 1, right, 2 * idx + 1);
            tree.putIfAbsent(2 * idx, new int[2]);
            tree.putIfAbsent(2 * idx + 1, new int[2]);
            tree.get(idx)[0] = tree.get(idx)[1] + Math.max(tree.get(2 * idx)[0],
                tree.get(2 * idx + 1)[0]);
        }
    }
}
