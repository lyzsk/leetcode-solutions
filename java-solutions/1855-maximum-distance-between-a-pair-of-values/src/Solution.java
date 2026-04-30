/**
 *
 * @author sichu huang
 * @since 2026/04/19 10:23
 */
public class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int res = 0;

        for (int j = 0; j < n2; j++) {
            while (i < n1 && nums1[i] > nums2[j]) {
                i++;
            }
            if (i < n1) {
                res = Math.max(res, j - i);
            }
        }

        return res;
    }
}
