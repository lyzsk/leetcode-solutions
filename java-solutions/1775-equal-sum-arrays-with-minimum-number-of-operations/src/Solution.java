import java.util.Arrays;

/**
 * @author sichu
 * @date 2022/12/06
 **/
public class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (6 * m < n || 6 * n < m) {
            return -1;
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int num : nums1) {
            sum1 += num;
        }
        for (int num : nums2) {
            sum2 += num;
        }
        if (sum1 == sum2) {
            return 0;
        }
        int[] larger;
        int[] smaller;
        if (sum1 > sum2) {
            larger = nums1;
            smaller = nums2;
        } else {
            larger = nums2;
            smaller = nums1;
        }
        int diff = Math.abs(sum1 - sum2);
        Arrays.sort(larger);
        Arrays.sort(smaller);
        int res = 0;
        // i: smaller ptr, smaller sorted from low to high
        // j: larger ptr, larger sorted from high to low
        int i = 0;
        int j = larger.length - 1;
        while (i < smaller.length && j >= 0) {
            int add = 0;
            if (6 - smaller[i] >= larger[j] - 1) {
                add = 6 - smaller[i++];
            } else {
                add = larger[j--] - 1;
            }
            if (add == 0) {
                return -1;
            }
            diff -= add;
            ++res;
            if (diff <= 0) {
                return res;
            }
        }
        while (i < smaller.length) {
            int add = 6 - smaller[i++];
            if (add == 0) {
                return -1;
            }
            diff -= add;
            ++res;
            if (diff <= 0) {
                return res;
            }
        }
        while (j >= 0) {
            int add = larger[j--] - 1;
            if (add == 0) {
                return -1;
            }
            diff -= add;
            ++res;
            if (diff <= 0) {
                return res;
            }
        }
        return -1;
    }
}
