import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sichu
 * @date 2024/01/02
 **/
public class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!map.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> toErase = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int k = entry.getKey();
                int v = entry.getValue();
                temp.add(k);
                --v;
                if (v == 0) {
                    toErase.add(k);
                }
                map.put(k, v);
            }
            res.add(temp);
            for (int i : toErase) {
                map.remove(i);
            }
        }
        return res;
    }
}
