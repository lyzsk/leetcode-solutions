/**
 * @author sichu huang
 * @since 2025/02/20 11:35
 */
public class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (nums[i].charAt(i) == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return sb.toString();
    }
}
