import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu
 * @date 2022/10/07
 **/
public class MyCalendarThree {
    private Map<Integer, Integer> tree;
    private Map<Integer, Integer> lazy;

    public MyCalendarThree() {
        this.tree = new HashMap<>(16);
        this.lazy = new HashMap<>(16);
    }

    public int book(int start, int end) {
        update(start, end - 1, 0, 1000000000, 1);
        return tree.getOrDefault(1, 0);
    }

    private void update(int start, int end, int left, int right, int idx) {
        if (left > end || right < start) {
            return;
        }
        if (left >= start && right <= end) {
            tree.put(idx, tree.getOrDefault(idx, 0) + 1);
            lazy.put(idx, lazy.getOrDefault(idx, 0) + 1);
        } else {
            int mid = left + ((right - left) >> 1);
            update(start, end, left, mid, 2 * idx);
            update(start, end, mid + 1, right, 2 * idx + 1);
            tree.put(idx,
                lazy.getOrDefault(idx, 0) + Math.max(tree.getOrDefault(2 * idx, 0), tree.getOrDefault(2 * idx + 1, 0)));
        }
    }
}
