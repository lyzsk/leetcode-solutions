import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author sichu huang
 * @since 2025/11/05 23:02
 */
public class Solution {
    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] sum = new long[1];
        Map<Integer, Integer> map = new HashMap<>();
        Comparator<int[]> comp = (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        };
        TreeSet<int[]> main = new TreeSet<>(comp);
        TreeSet<int[]> sec = new TreeSet<>(comp);
        long[] res = new long[n - k + 1];
        int i = 0;
        int j = 0;
        while (j < n) {
            int num = nums[j];
            int oldFreq = map.getOrDefault(num, 0);
            if (oldFreq > 0) {
                removeFromSet(main, sec, new int[] {oldFreq, num}, x, sum);
            }
            map.put(num, oldFreq + 1);
            insertInSet(main, sec, new int[] {oldFreq + 1, num}, x, sum);
            if (j - i + 1 == k) {
                res[i] = sum[0];
                int outNum = nums[i];
                int outFreq = map.get(outNum);
                removeFromSet(main, sec, new int[] {outFreq, outNum}, x, sum);
                if (outFreq == 1) {
                    map.remove(outNum);
                } else {
                    map.put(outNum, outFreq - 1);
                    insertInSet(main, sec, new int[] {outFreq - 1, outNum}, x, sum);
                }
                i++;
            }
            j++;
        }
        return res;
    }

    private int compare(int[] a, int[] b) {
        if (a[0] != b[0]) {
            return Integer.compare(a[0], b[0]);
        }
        return Integer.compare(a[1], b[1]);
    }

    private void insertInSet(TreeSet<int[]> main, TreeSet<int[]> sec, int[] p, int x, long[] sum) {
        if (main.size() < x || compare(p, main.first()) > 0) {
            main.add(p);
            sum[0] += 1L * p[0] * p[1];
            if (main.size() > x) {
                int[] smallest = main.pollFirst();
                sum[0] -= 1L * smallest[0] * smallest[1];
                sec.add(smallest);
            }
        } else {
            sec.add(p);
        }
    }

    private void removeFromSet(TreeSet<int[]> main, TreeSet<int[]> sec, int[] p, int x,
        long[] sum) {
        if (main.remove(p)) {
            sum[0] -= (long)p[0] * p[1];
            if (!sec.isEmpty()) {
                int[] largest = sec.pollLast();
                main.add(largest);
                assert largest != null;
                sum[0] += (long)largest[0] * largest[1];
            }
        } else {
            sec.remove(p);
        }
    }
}
