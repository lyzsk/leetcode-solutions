import java.util.Arrays;

/**
 * @author sichu
 * @date 2023/01/23
 **/
public class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long res = 0L;
        Integer[] idxs = new Integer[n];
        for (int i = 0; i < n; i++) {
            idxs[i] = i;
        }
        Arrays.sort(idxs, (o1, o2) -> Integer.compare(nums2[o2], nums2[o1]));

    }
}
