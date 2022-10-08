import java.util.Arrays;
import java.util.Comparator;

/**
 * @author sichu
 * @date 2022/10/08
 **/
public class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int n = nums1.length;
        Integer[] index = new Integer[n];
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        // Arrays.sort(index, (idx1, idx2) -> (nums2[idx1] - nums2[idx2]));
        Arrays.sort(index, Comparator.comparingInt(idx -> nums2[idx]));
        int left = 0;
        int right = n - 1;
        for (int num : nums1) {
            int i = num > nums2[index[left]] ? index[left++] : index[right--];
            res[i] = num;
        }
        return res;
    }
}
