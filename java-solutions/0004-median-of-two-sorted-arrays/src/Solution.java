/**
 * @author sichu
 * @date 2022/10/18
 **/
public class Solution {
    private static int getKthElement(int[] nums1, int[] nums2, int k) {
        int idx1 = 0;
        int idx2 = 0;
        while (true) {
            if (idx1 == nums1.length) {
                return nums2[idx2 + k - 1];
            }
            if (idx2 == nums2.length) {
                return nums1[idx1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[idx1], nums2[idx2]);
            }

            int half = k / 2;
            int newIdx1 = Math.min(idx1 + half, nums1.length) - 1;
            int newIdx2 = Math.min(idx2 + half, nums2.length) - 1;
            int pivot1 = nums1[newIdx1];
            int pivot2 = nums2[newIdx2];
            if (pivot1 <= pivot2) {
                k -= (newIdx1 - idx1 + 1);
                idx1 = newIdx1 + 1;
            } else {
                k -= (newIdx2 - idx2 + 1);
                idx2 = newIdx2 + 1;
            }
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 1) {
            int midIdx = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIdx + 1);
            return median;
        } else {
            int midIdx1 = totalLength / 2 - 1;
            int midIdx2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIdx1 + 1) + getKthElement(nums1, nums2, midIdx2 + 1)) / 2.0;
            return median;
        }
    }
}
