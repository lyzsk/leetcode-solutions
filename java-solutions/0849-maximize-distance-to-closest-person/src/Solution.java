/**
 * @author sichu
 * @date 2023/08/22
 **/
public class Solution {
    public int maxDistToClosest(int[] seats) {
        int res = 0;
        int left = 0;
        int n = seats.length;
        while (left < n && seats[left] == 0) {
            ++left;
            res = Math.max(res, left);
        }
        while (left < n) {
            int right = left + 1;
            while (right < n && seats[right] == 0) {
                ++right;
            }
            if (right == n) {
                res = Math.max(res, right - left - 1);
            } else {
                res = Math.max(res, (right - left) >> 1);
            }
            left = right;
        }
        return res;
    }
}
