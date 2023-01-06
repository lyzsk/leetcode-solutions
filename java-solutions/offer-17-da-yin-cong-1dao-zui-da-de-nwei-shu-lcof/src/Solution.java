/**
 * @author sichu
 * @date 2023/01/06
 **/
public class Solution {
    public int[] printNumbers(int n) {
        n = (int)(Math.pow(10, n) - 1);
        int[] res = new int[n];
        for (int i = 1; i <= n; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}
