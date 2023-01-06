import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sichu
 * @date 2023/01/06
 **/
public class Solution {
    public int distinctAverages(int[] nums) {
        if (nums == null || nums.length < 2 || nums.length % 2 != 0) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        Set<Integer> set = new HashSet<>();
        while (left < right) {
            int sum = nums[left++] + nums[right--];
            set.add(sum);
        }
        return set.size();
    }
}
