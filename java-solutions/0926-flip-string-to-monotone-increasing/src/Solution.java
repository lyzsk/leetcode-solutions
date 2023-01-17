/**
 * @author sichu
 * @date 2023/01/17
 **/
public class Solution {
    public int minFlipsMonoIncr(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] presum = new int[n + 1];
        int res = n;
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + (arr[i - 1] - '0');
        }
        for (int i = 1; i <= n; i++) {
            int left = presum[i - 1];
            int right = (n - i) - (presum[n] - presum[i]);
            res = Math.min(res, left + right);
        }
        return res;
    }
}
