import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/12/28
 **/
public class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> res = new ArrayList<>();
        int[] hash = new int[101];
        for (int num : nums1) {
            if (hash[num] == 0) {
                hash[num] += 1;
            }
        }
        for (int num : nums2) {
            if (hash[num] == 0) {
                hash[num] += 2;
            } else if (hash[num] == 1) {
                hash[num] += 2;
                res.add(num);
            }
        }
        for (int num : nums3) {
            if (hash[num] == 1 || hash[num] == 2) {
                hash[num] += 3;
                res.add(num);
            }
        }
        return res;
    }
}
