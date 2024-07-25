import java.util.*;

/**
 * @author sichu huang
 * @date 2024/07/23
 **/
public class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>(16);
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Collections.sort(list, (o1, o2) -> {
            int count1 = count.get(o1);
            int count2 = count.get(o2);
            return count1 != count2 ? count1 - count2 : o2 - o1;
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
