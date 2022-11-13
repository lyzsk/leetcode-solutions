/**
 * @author sichu
 * @date 2022/11/13
 **/
public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        int res = 0;
        while (left < right) {
            area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return res;
    }
}
