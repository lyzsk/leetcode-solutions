/**
 * @author sichu
 * @date 2022/11/13
 **/
public class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int w = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                ++w;
            }
        }
        int res = w;
        for (int i = k; i < n; i++) {
            if (blocks.charAt(i - k) == 'W') {
                --w;
            }
            if (blocks.charAt(i) == 'W') {
                ++w;
            }
            res = Math.min(res, w);
        }
        return res;
    }
}
