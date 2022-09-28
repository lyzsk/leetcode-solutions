import java.util.ArrayList;
import java.util.List;

/**
 * @author sichu
 * @date 2022/08/25
 **/
public class Solution {
    private static int binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int right = binarySearch(arr, x);
        int left = right - 1;
        while (k-- > 0) {
            if (left < 0) {
                ++right;
            } else if (right >= arr.length) {
                --left;
            } else if (x - arr[left] <= arr[right] - x) {
                --left;
            } else {
                ++right;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left + 1; i < right; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
