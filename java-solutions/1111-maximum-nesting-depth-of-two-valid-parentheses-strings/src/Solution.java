/**
 *
 * @author sichu huang
 * @since 2026/09/30
 */
public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int d = 0;
        int length = seq.length();
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            if (seq.charAt(i) == '(') {
                ++d;
                res[i] = d % 2;
            } else {
                res[i] = d % 2;
                --d;
            }
        }
        return res;
    }
}
