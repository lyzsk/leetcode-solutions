/**
 * @author sichu
 * @date 2023/01/22
 **/
public class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                ++i;
            } else {
                ++j;
            }
        }
        return -1;
    }
}
