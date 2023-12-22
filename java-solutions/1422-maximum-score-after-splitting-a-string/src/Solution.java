/**
 * @author sichu
 * @date 2022/08/14
 **/
public class Solution {
    public int maxScore(String s) {
        int res = 0;
        int zeros = 0;
        int ones = 0;
        char[] arr = s.toCharArray();
        for (char ch : arr) {
            ones += ch == '1' ? 1 : 0;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == '0') {
                ++zeros;
            } else {
                --ones;
            }
            res = Math.max(res, zeros + ones);
        }
        return res;
    }
}
