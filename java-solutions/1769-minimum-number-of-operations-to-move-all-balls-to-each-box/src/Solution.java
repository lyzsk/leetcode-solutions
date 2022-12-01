/**
 * @author sichu
 * @date 2022/12/01
 **/
public class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int left = boxes.charAt(0) - '0';
        int right = 0;
        int operations = 0;
        for (int i = 1; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                ++right;
                operations += i;
            }
        }
        int[] res = new int[n];
        res[0] = operations;
        for (int i = 1; i < n; i++) {
            operations += (left - right);
            res[i] = operations;
            if (boxes.charAt(i) == '1') {
                ++left;
                --right;
            }
        }
        return res;
    }
}
