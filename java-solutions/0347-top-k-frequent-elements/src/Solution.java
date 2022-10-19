import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author sichu
 * @date 2022/10/19
 **/
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 方法一
        // Map<Integer, Integer> freq = new HashMap<>(16);
        // Arrays.stream(nums).forEach(num -> freq.put(num, freq.getOrDefault(num, 0) + 1));
        // return freq.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).limit(k)
        //     .mapToInt(Map.Entry::getKey).toArray();

        // 方法二
        Map<Integer, Integer> freq = new HashMap<>(16);
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        // PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();
            if (pq.size() == k) {
                if (pq.peek()[1] < cnt) {
                    pq.poll();
                    pq.offer(new int[] {num, cnt});
                }
            } else {
                pq.offer(new int[] {num, cnt});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
        
        // 方法三
        // Map<Integer, Integer> freq = new HashMap<>(16);
        // for (int num : nums) {
        //     freq.put(num, freq.getOrDefault(num, 0) + 1);
        // }
        // PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        // for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
        //     pq.offer(entry);
        //     if (pq.size() > k) {
        //         pq.poll();
        //     }
        // }
        // int[] res = new int[k];
        // for (int i = 0; i < k; i++) {
        //     res[i] = pq.poll().getKey();
        // }
        // return res;
    }
}
