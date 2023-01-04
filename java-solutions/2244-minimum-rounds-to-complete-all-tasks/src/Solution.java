import java.util.Arrays;

/**
 * @author sichu
 * @date 2023/01/04
 **/
public class Solution {
    public int minimumRounds(int[] tasks) {
        if (tasks.length == 1) {
            return -1;
        }
        int res = 0;
        Arrays.sort(tasks);
        for (int left = 0; left < tasks.length; ) {
            int right = left + 1;
            while (right < tasks.length && tasks[left] == tasks[right]) {
                ++right;
            }
            if (right == left + 1) {
                return -1;
            } else if ((right - left) % 3 == 0) {
                res += (right - left) / 3;
            } else {
                res += (right - left) / 3 + 1;
            }
            left = right;
        }
        return res;

        // if (tasks.length == 1) {
        //     return -1;
        // }
        // int res = 0;
        // Map<Integer, Integer> map = new HashMap<>(16);
        // for (int task : tasks) {
        //     map.put(task, map.getOrDefault(task, 0) + 1);
        // }
        // for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        //     int count = entry.getValue();
        //     if (count == 1) {
        //         return -1;
        //     } else if (count % 3 == 0) {
        //         res += count / 3;
        //     } else {
        //         res += count / 3 + 1;
        //     }
        // }
        // return res;
    }
}
