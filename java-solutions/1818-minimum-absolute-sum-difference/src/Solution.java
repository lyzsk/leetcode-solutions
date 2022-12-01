import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/11/30
 **/
public class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] sorted1 = nums1.clone();
        Arrays.sort(sorted1);
        int mx = Integer.MIN_VALUE;
        long sumDiff = 0;
        for (int i = 0; i < nums2.length; ++i) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sumDiff += diff;
            // Either sorted1[idx] or sorted1[idx - 1] has the minimum difference from nums2[i].
            int idx = Arrays.binarySearch(sorted1, nums2[i]);
            if (idx < 0) {
                idx = ~idx; // ~idx = -idx - 1, locate the insertion point.
            }
            if (idx < sorted1.length) {
                mx = Math.max(mx, diff - Math.abs(sorted1[idx] - nums2[i]));
            }
            if (idx > 0) {
                mx = Math.max(mx, diff - Math.abs(sorted1[idx - 1] - nums2[i]));
            }
        }
        return (int)((sumDiff - mx) % 1_000_000_007);
    }
}
