import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author sichu huang
 * @since 2025/02/08 11:10
 */
public class NumberContainers {

    private Map<Integer, Integer> k;
    private Map<Integer, TreeSet<Integer>> v;

    public NumberContainers() {
        k = new HashMap<>();
        v = new HashMap<>();
    }

    public void change(int index, int number) {
        Integer num = k.get(index);
        if (num != null) {
            v.get(num).remove(index);
        }
        k.put(index, number);
        TreeSet<Integer> s = v.computeIfAbsent(number, k1 -> new TreeSet<>());
        s.add(index);
    }

    public int find(int number) {
        TreeSet<Integer> s = v.getOrDefault(number, new TreeSet<>());
        return s.isEmpty() ? -1 : s.first();
    }
}
