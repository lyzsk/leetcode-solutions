import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author sichu
 * @date 2022/10/24
 **/
public class MyCalendar {
    private TreeSet<int[]> booked;

    public MyCalendar() {
        this.booked = new TreeSet<>(Comparator.comparingInt(o -> o[0]));
    }

    public boolean book(int start, int end) {
        if (booked.isEmpty()) {
            booked.add(new int[] {start, end});
            return true;
        }
        int[] temp = {end, 0};
        int[] arr = booked.ceiling(temp);
        int[] prev = arr == null ? booked.last() : booked.lower(arr);
        if (arr == booked.first() || booked.lower(temp)[1] <= start) {
            booked.add(new int[] {start, end});
            return true;
        }
        return false;
    }
}
