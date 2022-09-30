import java.util.*;

/**
 * @author sichu
 * @date 2022/09/30
 **/
public class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Integer> boundaries = new ArrayList<>();
        for (int[] building : buildings) {
            boundaries.add(building[0]);
            boundaries.add(building[1]);
        }
        Collections.sort(boundaries);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        List<List<Integer>> res = new ArrayList<>();
        int idx = 0;
        for (int bounday : boundaries) {
            while (idx < buildings.length && buildings[idx][0] <= bounday) {
                maxHeap.offer(new int[] {buildings[idx][1], buildings[idx][2]});
                ++idx;
            }
            while (!maxHeap.isEmpty() && maxHeap.peek()[0] <= bounday) {
                maxHeap.poll();
            }
            int maxHeight = maxHeap.isEmpty() ? 0 : maxHeap.peek()[1];
            if (res.size() == 0 || maxHeight != res.get(res.size() - 1).get(1)) {
                res.add(Arrays.asList(bounday, maxHeight));
            }
        }
        return res;
    }
}
