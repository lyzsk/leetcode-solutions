import java.util.HashMap;
import java.util.Map;

/**
 * @author sichu huang
 * @date 2024/08/05
 **/
public class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : arr) {
            int value = map.get(s);
            if (value == 1) {
                --k;
                if (k == 0) {
                    return s;
                }
            }
        }
        return "";
    }
}
