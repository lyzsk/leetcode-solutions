/**
 * @author sichu
 * @date 2022/11/07
 **/
public class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int idx = 0;
        int temp = 1;
        if (n % 2 != 0) {
            res[idx++] = 0;
        }
        while (idx < n) {
            res[idx++] = temp;
            res[idx++] = -temp;
            ++temp;
        }
        return res;
    }
}
