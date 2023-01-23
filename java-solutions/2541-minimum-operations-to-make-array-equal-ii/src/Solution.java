import java.util.Arrays;

/**
 * @author sichu
 * @date 2023/01/23
 **/
public class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if (k == 0) {
            return Arrays.equals(nums1, nums2) ? 0 : -1;
        }
        long ops1 = 0;
        long ops2 = 0;
        // nums1.length == nums2.length
        for (int i = 0; i < nums1.length; i++) {
            int diff = nums2[i] - nums1[i];
            if (diff % k != 0) {
                return -1;
            }
            if (diff > 0) {
                ops1 += diff / k;
            } else if (diff < 0) {
                ops2 += -diff / k;
            }
        }
        if (ops1 == ops2) {
            return ops1;
        }
        return -1;
    }
}
