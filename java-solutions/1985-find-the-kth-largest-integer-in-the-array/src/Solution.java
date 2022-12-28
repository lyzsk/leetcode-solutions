import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/11/27
 **/
public class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (o1, o2) -> {
            int len1 = o1.length();
            int len2 = o2.length();
            if (len1 != len2) {
                return len2 - len1;
            }
            return o2.compareTo(o1);
        });
        return nums[k - 1];
    }
}
