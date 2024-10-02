import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @date 2024/10/02
 **/
public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] sortedArr = new int[n];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        Arrays.sort(sortedArr);
        Map<Integer, Integer> map = new HashMap<>(n);
        int[] res = new int[n];
        for (int item : sortedArr) {
            if (!map.containsKey(item)) {
                map.put(item, map.size() + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}
