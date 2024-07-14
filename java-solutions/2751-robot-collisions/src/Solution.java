import java.util.*;

/**
 * @author sichu huang
 * @date 2024/07/13
 **/
public class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] id = new Integer[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        Arrays.sort(id, Comparator.comparingInt(i -> positions[i]));
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : id) {
            if (directions.charAt(i) == 'R') {
                stack.addFirst(i);
                continue;
            }
            while (!stack.isEmpty()) {
                int top = stack.peekFirst();
                if (healths[top] > healths[i]) {
                    --healths[top];
                    healths[i] = 0;
                    break;
                }
                if (healths[top] == healths[i]) {
                    healths[stack.removeFirst()] = 0;
                    healths[i] = 0;
                    break;
                }
                healths[stack.removeFirst()] = 0;
                --healths[i];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int h : healths) {
            if (h > 0) {
                res.add(h);
            }
        }
        return res;
    }
}
