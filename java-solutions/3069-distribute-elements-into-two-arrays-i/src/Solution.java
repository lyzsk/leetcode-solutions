import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sichu huang
 * @since 2026/08/20
 */
public class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for (int i = 2; i < n; i++) {
            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1)) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }
        int[] res = new int[n];
        int idx = 0;
        for (int x : arr1) {
            res[idx++] = x;
        }
        for (int x : arr2) {
            res[idx++] = x;
        }
        return res;
    }
}
