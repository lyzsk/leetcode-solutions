import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/10/20
 **/
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] res = new int[m + n];
        int idx = 0;
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < m && idx2 < n) {
            int num1 = nums1[idx1];
            int num2 = nums2[idx2];
            if (num1 == num2) {
                if (idx == 0 || num1 != res[idx - 1]) {
                    res[idx++] = num1;
                }
                ++idx1;
                ++idx2;
            } else if (num1 < num2) {
                ++idx1;
            } else {
                ++idx2;
            }
        }
        return Arrays.copyOfRange(res, 0, idx);
    }
}
