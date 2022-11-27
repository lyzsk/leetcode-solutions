import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/11/27
 **/
public class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (o1, o2) -> {
            int o1Len = o1.length();
            int o2Len = o2.length();
            if (o1Len != o2Len) {
                return o2Len - o1Len;
            }
            return o2.compareTo(o1);
        });
        return nums[k - 1];
    }
}
