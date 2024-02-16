import java.util.*;

/**
 * @author sichu
 * @date 2024/02/16
 **/
public class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>(arr.length);
        for (int i : arr) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> elements = new ArrayList<>(freq.entrySet());
        elements.sort(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> element : elements) {
            if (element.getValue() <= k) {
                k -= element.getValue();
                freq.remove(element.getKey());
            } else {
                break;
            }
        }
        return freq.size();
    }
}
