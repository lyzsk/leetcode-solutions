/**
 * @author sichu huang
 * @date 2024/05/28
 **/
public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int start = 0;
        int curCost = 0;
        int maxLength = 0;
        for (int end = 0; end < n; end++) {
            curCost += Math.abs(s.charAt(end) - t.charAt(end));
            while (curCost > maxCost) {
                curCost -= Math.abs(s.charAt(start) - t.charAt(start));
                ++start;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
