import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu
 * @date 2022/10/24
 **/
public class MyCalendar {
    Set<Integer> tree;
    Set<Integer> temp;

    public MyCalendar() {
        tree = new HashSet<>();
        temp = new HashSet<>();
    }

    public boolean book(int start, int end) {
        if (query(start, end - 1, 0, 1000000000, 1)) {
            return false;
        }
        update(start, end - 1, 0, 1000000000, 1);
        return true;
    }

    private boolean query(int start, int end, int left, int right, int idx) {
        if (start > right || end < left) {
            return false;
        }
        if (temp.contains(idx)) {
            return true;
        }
        if (start <= left && right <= end) {
            return tree.contains(idx);
        } else {
            int mid = ((left + right) >> 1);
            if (end <= mid) {
                return query(start, end, left, mid, 2 * idx);
            } else if (start > mid) {
                return query(start, end, mid + 1, right, 2 * idx + 1);
            } else {
                return query(start, end, left, mid, 2 * idx) | query(start, end,
                    mid + 1, right, 2 * idx + 1);
            }
        }
    }

    private void update(int start, int end, int left, int right, int idx) {
        if (right < start || end < left) {
            return;
        }
        if (start <= left && right <= end) {
            tree.add(idx);
            temp.add(idx);
        } else {
            int mid = ((left + right) >> 1);
            update(start, end, left, mid, 2 * idx);
            update(start, end, mid + 1, right, 2 * idx + 1);
            tree.add(idx);
        }
    }
}
