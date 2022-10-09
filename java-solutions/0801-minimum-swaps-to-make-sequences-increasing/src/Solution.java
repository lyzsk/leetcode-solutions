/**
 * @author sichu
 * @date 2022/10/09
 **/
public class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int fix = 0;
        int swap = 1;
        for (int i = 1; i < nums1.length; i++) {
            if (nums1[i] <= nums1[i - 1] || nums2[i] <= nums2[i - 1]) {
                int temp = swap;
                swap = fix + 1;
                fix = temp;
            } else if (nums1[i] <= nums2[i - 1] || nums2[i] <= nums1[i - 1]) {
                ++swap;
            } else {
                int min = Math.min(fix, swap);
                fix = min;
                swap = min + 1;
            }
        }
        return Math.min(fix, swap);
    }
}
