import java.util.Arrays;

/**
 * @author sichu
 * @date 2023/09/30
 **/
public class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (o1, o2) -> Integer.compare(growTime[o2], growTime[o1]));
        int res = 0;
        int plant = 0;
        for (Integer index : indices) {
            plant += plantTime[index];
            res = Math.max(res, plant + growTime[index]);
        }
        return res;
    }
}
